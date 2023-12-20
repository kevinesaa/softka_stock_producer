package com.esaa.corp.stock.producer.sales.useCases.createSale;

import com.esaa.corp.stock.producer._commons.models.database.*;
import com.esaa.corp.stock.producer.itemPrice.drivenAdapters.respositories.IPriceRepository;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.sales.drivenAdapters.respositories.ISaleDetailRepository;
import com.esaa.corp.stock.producer.sales.drivenAdapters.respositories.ISaleRepository;
import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import com.esaa.corp.stock.producer.stock.drivenAdapters.respositories.IStockSingleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateSaleUseCase implements ICreateSaleUseCase {

    @Autowired
    private ISaleRepository saleRepository;
    @Autowired
    private ISaleDetailRepository saleDetailRepository;
    @Autowired
    private IStockSingleMovementRepository stockSingleMovementRepository;
    @Autowired
    private IItemRepository itemRepository;
    @Autowired
    private IPriceRepository priceRepository;

    @Autowired
    private CreateSaleMapper mapper;

    @Override
    public Mono<SaleResponseDto> apply(final PriceTypeEnum priceTypeEnum,final SaleRequestDto saleRequestDto) {


        return Flux.fromIterable(saleRequestDto.getItems())
                .flatMap(item ->
                        itemRepository.findById(item.getItemId())
                                .zipWith(priceRepository.findByItemIdAndTypePriceCode(item.getItemId(), priceTypeEnum.getPriceCode()))
                                .filter(tuple -> {
                                    final Item t1 = tuple.getT1();
                                    final ItemPrice t2 = tuple.getT2();
                                    Long minUnits = t2.getMinUnits();
                                    Long oldQuantity = t1.getQuantity();
                                    Long newQuantity = oldQuantity - item.getQuantity();
                                    return newQuantity >= 0 && item.getQuantity() >= minUnits;
                                })
                                .flatMap(t -> {
                                    ItemPrice t2 = t.getT2();
                                    Item t1 = t.getT1();
                                    t2.setItem(t1);
                                    Item entity = new Item();
                                    entity.setId(t1.getId());
                                    entity.setName(t1.getName());
                                    entity.setCode(t1.getCode());
                                    entity.setQuantity(t1.getQuantity() - item.getQuantity());

                                    return itemRepository.save(entity).thenReturn(Tuples.of(item, t2));
                                })
                )
                .flatMap(tuple -> {

                    ItemPrice t2 = tuple.getT2();
                    Item item = t2.getItem();
                    SaleDetail saleDetail = mapper.singleItemRequestModelToDbModel(tuple.getT1());
                    saleDetail.setItemCode(item.getCode());
                    saleDetail.setItemName(item.getName());
                    saleDetail.setPricePerUnit(t2.getPricePerUnit());
                    saleDetail.setItemPriceId(t2.getId());
                    saleDetail.setPriceType(t2.getPriceType());
                    saleDetail.setMinUnitsPriceType(t2.getMinUnits());
                    saleDetail.setPriceTypeName(t2.getPriceName());

                    return saleDetailRepository
                            .save(saleDetail)
                            .flatMap(saleDetailSaved -> {

                                ItemMovement movement = new ItemMovement();
                                movement.setItem(tuple.getT2().getItem());
                                movement.setSaleDetailId(saleDetailSaved.getSaleDetailId());
                                movement.setQuantity((-1) * saleDetailSaved.getSaleQuantity());
                                movement.setReason(saleDetailSaved.getPriceTypeName());

                                return stockSingleMovementRepository
                                        .save(movement)
                                        .thenReturn(saleDetailSaved);
                            });
                })
                .reduce(new Sale(), (acc, current) -> {
                    if (acc.getItems() == null) {
                        acc.setItems(new ArrayList<>());
                    }
                    acc.getItems().add(current);
                    return acc;
                })
                .flatMap(sale -> saleRepository.save(sale).flatMap(saleCompleted -> {
                    List<SaleDetail> saleDetails = saleCompleted.getItems().stream().peek(i -> i.setSaleId(saleCompleted.getId())).toList();
                    saleCompleted.setItems(saleDetails);
                    sale.setId(saleCompleted.getId());
                    sale.setItems(saleDetails);
                    return saleDetailRepository.saveAll(saleDetails).collectList().thenReturn(saleCompleted);
                }))
                .map(mapper::saleDbModelToResponseModel);

    }
}

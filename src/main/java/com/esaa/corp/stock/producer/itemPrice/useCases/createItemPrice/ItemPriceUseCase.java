package com.esaa.corp.stock.producer.itemPrice.useCases.createItemPrice;

import com.esaa.corp.stock.producer._commons.models.database.ItemPrice;
import com.esaa.corp.stock.producer._commons.models.database.PriceTypeEnum;
import com.esaa.corp.stock.producer.itemPrice.drivenAdapters.respositories.IPriceRepository;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceRequestDto;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceResponseDto;
import com.esaa.corp.stock.producer.itemPrice.models.mappers.CreateItemPriceMapper;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.priceTypes.drivenAdapters.respositories.IPriceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ItemPriceUseCase implements IItemPriceUseCase {

    @Autowired
    private IPriceRepository priceRepository;

    @Autowired
    private IItemRepository itemRepository;

    @Autowired
    private IPriceTypeRepository priceTypeRepository;

    @Autowired
    private CreateItemPriceMapper mapper;

    @Override
    public Mono<CreateItemPriceResponseDto> apply(CreateItemPriceRequestDto requestModel) {

       return priceRepository
                .findByItemIdAndTypePriceCode(requestModel.getItemId(),requestModel.getPriceTypeCode())
                .switchIfEmpty(

                     itemRepository
                            .findById(requestModel.getItemId())
                            .zipWith(priceTypeRepository.findByPriceTypeCode(requestModel.getPriceTypeCode()))
                            .map(tuple -> {
                                final ItemPrice itemPrice = mapper.requestModelToDbModel(requestModel);
                                itemPrice.setItem(tuple.getT1());
                                itemPrice.setPriceType(tuple.getT2());
                                return itemPrice;
                            })

                ).flatMap(itemPrice -> {

                    itemPrice.setPriceName(requestModel.getPriceName());
                    itemPrice.setMinUnits(requestModel.getMinUnits());
                    itemPrice.setPricePerUnit(requestModel.getPricePerUnit());

                    return priceRepository.save(itemPrice).map( mapper::dbModelToResponseModel);
                });

    }
}

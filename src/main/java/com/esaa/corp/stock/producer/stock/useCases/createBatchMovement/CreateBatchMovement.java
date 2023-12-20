package com.esaa.corp.stock.producer.stock.useCases.createBatchMovement;

import com.esaa.corp.stock.producer._commons.models.database.Batch;
import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.stock.drivenAdapters.respositories.IBatchSingleMovementRepository;
import com.esaa.corp.stock.producer.stock.drivenAdapters.respositories.IStockSingleMovementRepository;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementResponseDto;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateBatchStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class CreateBatchMovement implements ICreateBatchMovement{

    @Autowired
    private IBatchSingleMovementRepository batchRepository;

    @Autowired
    private IStockSingleMovementRepository singleMovementRepository;

    @Autowired
    private IItemRepository itemRepository;

    @Autowired
    private CreateBatchStockMapper batchStockMapper;



    @Override
    public Mono<CreateBatchMovementResponseDto> apply(final CreateBatchMovementRequestDto requestDto) {

        final Batch bathBeforeInsert = batchStockMapper.batchRequestToBachDb(requestDto);

        return itemRepository
                .findAllById(bathBeforeInsert.getItems().stream().map(ItemMovement::getItemId).toList())
                .flatMap(dbItem -> {
                    Stream<Mono<ItemMovement>> monoStream = bathBeforeInsert
                            .getItems()
                            .stream()
                            .filter(i -> i.getItemId().equalsIgnoreCase(dbItem.getId()))
                            .peek(i -> i.setItem(dbItem))
                            .map(movement -> {
                                return singleMovementRepository
                                        .save(movement)
                                        .flatMap(movementCompleted -> {
                                            Item itemFromMovement = movementCompleted.getItem();
                                            final long oldQuantity = dbItem.getQuantity();
                                            final long newQuantity = oldQuantity + movementCompleted.getQuantity();
                                            dbItem.setQuantity(newQuantity);
                                            return itemRepository.save(dbItem).thenReturn(movementCompleted);
                                        });
                            });
                    return Flux.concat( monoStream.toList());

                }).reduce(new Batch(),(acc,current) -> {

                    if(acc.getItems() == null) {
                        acc.setReason(requestDto.getReason());
                        acc.setItems(new ArrayList<>());
                    }
                    acc.getItems().add(current);
                    return acc;

                }).flatMap(batch ->

                        batchRepository.save(batch).map( batchCompleted-> {

                            List<ItemMovement> movementList = batchCompleted.getItems().stream().peek(i -> i.setBatchId(batchCompleted.getId())).toList();
                            batchCompleted.setItems(movementList);
                            batch.setItems(movementList);
                            return singleMovementRepository
                                    .saveAll(movementList)
                                    .flatMap(itemMovement -> {
                                       return itemRepository
                                               .findById(itemMovement.getItemId())
                                               .map(item-> {
                                                   itemMovement.setItem(item);
                                                   return itemMovement;
                                               }).thenReturn(itemMovement);

                                    })
                                    .collectList()
                                    .and(batchRepository.save(batchCompleted))
                                    .thenReturn(batchCompleted);

                        }).thenReturn(batch)

                ).map(batch -> batchStockMapper.batchDbModelToResponseModel(batch));
    }
}

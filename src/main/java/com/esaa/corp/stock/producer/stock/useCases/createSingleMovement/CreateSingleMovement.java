package com.esaa.corp.stock.producer.stock.useCases.createSingleMovement;

import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.stock.drivenAdapters.respositories.IStockSingleMovementRepository;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateSingleStackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateSingleMovement implements ICreateSingleMovementUseCase{

    @Autowired
    private IStockSingleMovementRepository singleMovementRepository;
    @Autowired
    private IItemRepository itemRepository;
    @Autowired
    private CreateSingleStackMapper mapper;

    @Override
    public Mono<CreateSingleMovementResponseDto> apply(final CreateSingleMovementRequestDto requestModel) {


        return itemRepository
                .findById(requestModel.getItemId())
                .flatMap(item -> {

                    final long oldQuantity = item.getQuantity() ;
                    final long newQuantity = oldQuantity + requestModel.getQuantity();
                    if(newQuantity < 0)
                    {
                        //todo throw exception
                    }
                    final ItemMovement movement = mapper.requestToDbModel(requestModel);
                    movement.setItem(item);
                    return singleMovementRepository
                            .save(movement)
                            .flatMap(movementCompleted -> {
                                item.setQuantity(newQuantity);
                                return itemRepository.save(item).thenReturn(movementCompleted);
                            });

                })
                .map( movement -> mapper.dbToResponseModel(movement));


    }
}

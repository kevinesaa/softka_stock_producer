package com.esaa.corp.stock.producer.stock.useCases.createSingleMovement;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementResponseDto;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateSingleStackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateSingleMovement implements ICreateSingleMovementUseCase{

    @Autowired
    private CreateSingleStackMapper mapper;

    @Override
    public Mono<CreateSingleMovementResponseDto> apply(CreateSingleMovementRequestDto requestModel) {
        final ItemMovement movement = mapper.requestToDbModel(requestModel);
        //find item by id
        movement.setItem(new Item());
        final CreateSingleMovementResponseDto response = mapper.dbToResponseModel(movement);
        return Mono.just(response);
    }
}

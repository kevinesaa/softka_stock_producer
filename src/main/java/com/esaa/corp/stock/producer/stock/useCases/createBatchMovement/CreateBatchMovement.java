package com.esaa.corp.stock.producer.stock.useCases.createBatchMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementResponseDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.SingleBatchItemResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateBatchMovement implements ICreateBatchMovement{


    @Override
    public Mono<CreateBatchMovementResponseDto> apply(CreateBatchMovementRequestDto requestDto) {
        CreateBatchMovementResponseDto response = new CreateBatchMovementResponseDto();
        response.setItems(List.of(new SingleBatchItemResponseDto()));
        return Mono.just(response);
    }
}

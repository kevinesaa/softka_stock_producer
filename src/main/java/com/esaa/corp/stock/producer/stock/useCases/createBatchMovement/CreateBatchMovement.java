package com.esaa.corp.stock.producer.stock.useCases.createBatchMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateBatchMovement implements ICreateBatchMovement{


    @Override
    public Mono<CreateBatchMovementResponseDto> apply(CreateBatchMovementRequestDto requestDto) {
        return Mono.just(new CreateBatchMovementResponseDto());
    }
}

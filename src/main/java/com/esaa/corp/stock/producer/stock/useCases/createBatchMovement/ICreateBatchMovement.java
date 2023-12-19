package com.esaa.corp.stock.producer.stock.useCases.createBatchMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateBatchMovement {

    Mono<CreateBatchMovementResponseDto> apply(CreateBatchMovementRequestDto resquest);
}

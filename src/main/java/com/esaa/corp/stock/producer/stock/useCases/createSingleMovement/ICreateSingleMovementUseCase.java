package com.esaa.corp.stock.producer.stock.useCases.createSingleMovement;

import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateSingleMovementUseCase {

    Mono<CreateSingleMovementResponseDto> apply(CreateSingleMovementRequestDto requestModel);
}

package com.esaa.corp.stock.producer.stock.useCases.createSingleMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateSingleMovementUseCase {

    Mono<CreateSingleMovementResponseDto> apply(CreateSingleMovementRequestDto requestModel);
}

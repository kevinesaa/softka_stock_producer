package com.esaa.corp.stock.producer.stock.handlers.routes;

import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.useCases.createSingleMovement.ICreateSingleMovementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class StockRoutes {

    @Bean
    public RouterFunction<ServerResponse> createSingleItemMovement(ICreateSingleMovementUseCase useCase)
    {
        return RouterFunctions.route(
                RequestPredicates
                        .POST("/stock/movement/create")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),

                request -> request.bodyToMono(CreateSingleMovementRequestDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
                );
    }
}

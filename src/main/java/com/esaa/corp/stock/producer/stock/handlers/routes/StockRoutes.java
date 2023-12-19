package com.esaa.corp.stock.producer.stock.handlers.routes;

import com.esaa.corp.stock.producer._commons.models.dto.PageRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.getStockItemsByPage.StockPageResponseDto;
import com.esaa.corp.stock.producer.stock.useCases.createBatchMovement.ICreateBatchMovement;
import com.esaa.corp.stock.producer.stock.useCases.createSingleMovement.ICreateSingleMovementUseCase;
import com.esaa.corp.stock.producer.stock.useCases.getStockByPages.IGetStockByPageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

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

    @Bean
    public RouterFunction<ServerResponse> createStockBatchItemsMovements(ICreateBatchMovement useCase) {

        return RouterFunctions.route(
                RequestPredicates
                        .POST("/stock/movement/create/batch")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CreateBatchMovementRequestDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getStockByPage(IGetStockByPageUseCase useCase) {

        return RouterFunctions.route(
                RequestPredicates
                        .GET("/stock/items")
                        //.and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                ,
                request ->
                        ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.getItems(new PageRequestDto.PageRequestDtoBuilder()
                                        .setPage(request.queryParam("page"))
                                        .setSize(request.queryParam("size"))
                                        .build())
                                , StockPageResponseDto.class
                        ))
        );
    }

}

package com.esaa.corp.stock.producer.sales.handlers.routes;

import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.useCases.createMayorSale.ICreateWholeSaleUseCase;
import com.esaa.corp.stock.producer.sales.useCases.createReatilSale.ICreateRetailSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SaleRoutes {

    @Bean
    public RouterFunction<ServerResponse> createRetailSale(ICreateRetailSaleUseCase useCase)
    {
        return RouterFunctions.route(
                RequestPredicates
                        .POST("/sale/retail")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),

                request -> request.bodyToMono(SaleRequestDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
                );
    }

    @Bean
    public RouterFunction<ServerResponse> createWholeSale(ICreateWholeSaleUseCase useCase)
    {
        return RouterFunctions.route(
                RequestPredicates
                        .POST("/sale/whole")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),

                request -> request.bodyToMono(SaleRequestDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
        );
    }
}

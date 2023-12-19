package com.esaa.corp.stock.producer.itemPrice.handlers.routes;

import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceRequestDto;
import com.esaa.corp.stock.producer.itemPrice.useCases.createItemPrice.IItemPriceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ItemPriceRoutes {

    @Bean
    public RouterFunction<ServerResponse> createItemPrice(IItemPriceUseCase useCase) {
        return RouterFunctions.route(
                RequestPredicates
                        .POST("/price/create")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),

                request -> request.bodyToMono(CreateItemPriceRequestDto.class)
                        .flatMap(useCase::apply)
                        .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
        );
    }
}

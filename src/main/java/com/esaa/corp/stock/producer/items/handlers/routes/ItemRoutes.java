package com.esaa.corp.stock.producer.items.handlers.routes;

import com.esaa.corp.stock.producer.items.models.dto.ItemCreateRequestDto;
import com.esaa.corp.stock.producer.items.useCases.createItem.ICreateItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ItemRoutes {

    @Bean
    public RouterFunction<ServerResponse> createItem(ICreateItem useCase) {

        return RouterFunctions.route(
                RequestPredicates.POST("/item/create").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                request ->
                        request.bodyToMono(ItemCreateRequestDto.class)
                                .flatMap(useCase::apply)
                                .flatMap(responseModel -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(responseModel))
        );

    }
}

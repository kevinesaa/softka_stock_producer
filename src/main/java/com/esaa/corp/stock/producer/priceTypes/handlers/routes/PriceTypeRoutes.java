package com.esaa.corp.stock.producer.priceTypes.handlers.routes;

import com.esaa.corp.stock.producer.priceTypes.models.dto.PriceTypeDto;
import com.esaa.corp.stock.producer.priceTypes.useCases.getPriceTypes.IGetPriceTypeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PriceTypeRoutes {

    @Bean
    public RouterFunction<ServerResponse> getPriceTypes(IGetPriceTypeUseCase useCase) {
        return RouterFunctions.route(
                RequestPredicates.GET("/price_types"),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(useCase.getPriceTypes(), PriceTypeDto.class))
        );
    }
}

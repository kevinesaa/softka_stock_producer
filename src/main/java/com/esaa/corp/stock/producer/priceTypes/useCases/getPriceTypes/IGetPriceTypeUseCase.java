package com.esaa.corp.stock.producer.priceTypes.useCases.getPriceTypes;

import com.esaa.corp.stock.producer.priceTypes.models.dto.PriceTypeDto;
import reactor.core.publisher.Flux;

public interface IGetPriceTypeUseCase {

    Flux<PriceTypeDto> getPriceTypes();
}

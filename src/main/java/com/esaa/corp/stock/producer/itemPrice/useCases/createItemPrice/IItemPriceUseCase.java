package com.esaa.corp.stock.producer.itemPrice.useCases.createItemPrice;

import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceRequestDto;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceResponseDto;
import reactor.core.publisher.Mono;

public interface IItemPriceUseCase {

    Mono<CreateItemPriceResponseDto> apply(CreateItemPriceRequestDto requestModel);
}

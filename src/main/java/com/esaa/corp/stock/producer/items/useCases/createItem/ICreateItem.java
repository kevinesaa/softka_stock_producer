package com.esaa.corp.stock.producer.items.useCases.createItem;

import com.esaa.corp.stock.producer.items.models.dto.ItemCreateRequestDto;
import com.esaa.corp.stock.producer.items.models.dto.ItemCreateResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateItem {

    Mono<ItemCreateResponseDto> apply(ItemCreateRequestDto requestModel);
}

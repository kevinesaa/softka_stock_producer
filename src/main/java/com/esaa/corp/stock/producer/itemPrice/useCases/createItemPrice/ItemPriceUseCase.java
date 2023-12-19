package com.esaa.corp.stock.producer.itemPrice.useCases.createItemPrice;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemPrice;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceRequestDto;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceResponseDto;
import com.esaa.corp.stock.producer.itemPrice.models.mappers.CreateItemPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ItemPriceUseCase implements IItemPriceUseCase {

    @Autowired
    private CreateItemPriceMapper mapper;

    @Override
    public Mono<CreateItemPriceResponseDto> apply(CreateItemPriceRequestDto requestModel) {
        final ItemPrice itemPrice = mapper.requestModelToDbModel(requestModel);
        //find item by id
        itemPrice.setItem(new Item());
        final CreateItemPriceResponseDto response = mapper.dbModelToResponseModel(itemPrice);
        return Mono.just(response);
    }
}

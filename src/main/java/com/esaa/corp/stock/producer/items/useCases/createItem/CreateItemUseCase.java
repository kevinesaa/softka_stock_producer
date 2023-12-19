package com.esaa.corp.stock.producer.items.useCases.createItem;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.items.models.dto.ItemCreateRequestDto;
import com.esaa.corp.stock.producer.items.models.dto.ItemCreateResponseDto;
import com.esaa.corp.stock.producer.items.models.mappers.CreateItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateItemUseCase implements ICreateItem {


    @Autowired
    private IItemRepository itemRepository;

    @Autowired
    private CreateItemMapper mapper;


    @Override
    public Mono<ItemCreateResponseDto> apply(ItemCreateRequestDto requestModel) {

        final Item item = mapper.requestModelToDbModel(requestModel);

        return itemRepository.save(item).map(itemCompleted -> mapper.dbModelToResponseModel(itemCompleted));
    }
}

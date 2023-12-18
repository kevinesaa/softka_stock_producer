package com.esaa.corp.stock.producer.items.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer.items.models.dto.ItemCreateRequestDto;
import com.esaa.corp.stock.producer.items.models.dto.ItemCreateResponseDto;

public class CreateItemMapper {


    public Item requestModelToDbModel(ItemCreateRequestDto requestModel) {
        final Item item = new Item();
        item.setCode(requestModel.getCode());
        item.setName(requestModel.getName());
        return item;
    }

    public ItemCreateResponseDto dbModelToResponseModel(Item item) {
        final ItemCreateResponseDto responseModel = new ItemCreateResponseDto();
        responseModel.setId(item.getId());
        responseModel.setCode(item.getCode());
        responseModel.setName(item.getName());
        return responseModel;
    }
}

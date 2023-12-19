package com.esaa.corp.stock.producer.stock.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer.stock.models.dto.getStockItemsByPage.ItemStockResponseDto;

public class StockItemMapper {
    public ItemStockResponseDto dbModelToResponseModel(final Item item) {
        ItemStockResponseDto response = new ItemStockResponseDto();
        response.setId(item.getId());
        response.setCode(item.getCode());
        response.setName(item.getName());
        response.setQuantity(item.getQuantity());
        return response;
    }
}

package com.esaa.corp.stock.producer.itemPrice.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemPrice;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceRequestDto;
import com.esaa.corp.stock.producer.itemPrice.models.dto.CreateItemPriceResponseDto;

public class CreateItemPriceMapper {

    public ItemPrice requestModelToDbModel(final CreateItemPriceRequestDto requestModel) {
        final  ItemPrice itemPrice = new ItemPrice();
        itemPrice.setItemId(requestModel.getItemId());
        itemPrice.setPriceName(requestModel.getPriceName());
        itemPrice.setpricePerUnit(requestModel.getPricePerUnit());
        itemPrice.setMinUnits(requestModel.getMinUnits());
        return itemPrice;
    }

    public CreateItemPriceResponseDto dbModelToResponseModel(final ItemPrice itemPrice) {

        final CreateItemPriceResponseDto response = new CreateItemPriceResponseDto();
        final Item item = itemPrice.getItem();

        response.setPriceId(itemPrice.getId());
        response.setPriceName(itemPrice.getPriceName());
        response.setpricePerUnit(itemPrice.getpricePerUnit());
        response.setMinUnit(itemPrice.getMinUnits());

        response.setItemId(item.getId());
        response.setItemName(item.getName());
        response.setItemCode(item.getCode());

        return response;
    }
}

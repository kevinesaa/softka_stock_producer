package com.esaa.corp.stock.producer.stock.models.dto.getStockItemsByPage;

import com.esaa.corp.stock.producer._commons.models.dto.PageResponseModel;
import com.esaa.corp.stock.producer._commons.models.dto.PageResponseWrapperDto;

import java.util.List;

public class StockPageResponseDto extends PageResponseWrapperDto<ItemStockResponseDto> {


    public StockPageResponseDto(List<ItemStockResponseDto> items, PageResponseModel page) {
        super(items, page);
    }
}

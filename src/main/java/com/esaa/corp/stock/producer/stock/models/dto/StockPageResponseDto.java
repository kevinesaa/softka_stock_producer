package com.esaa.corp.stock.producer.stock.models.dto;

import com.esaa.corp.stock.producer._commons.models.dto.PageResponseModel;

import java.util.List;

public class StockPageResponseDto {

    private List<ItemStockResponseDto> items;
    private PageResponseModel page;

    public List<ItemStockResponseDto> getItems() {
        return items;
    }

    public void setItems(List<ItemStockResponseDto> items) {
        this.items = items;
    }

    public PageResponseModel getPage() {
        return page;
    }

    public void setPage(PageResponseModel page) {
        this.page = page;
    }
}

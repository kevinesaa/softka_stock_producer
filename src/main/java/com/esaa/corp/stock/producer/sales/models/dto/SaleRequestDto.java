package com.esaa.corp.stock.producer.sales.models.dto;

import java.util.List;

public class SaleRequestDto {

    private List<SaleSingleItemRequestDto> items;

    public List<SaleSingleItemRequestDto> getItems() {
        return items;
    }

    public void setItems(List<SaleSingleItemRequestDto> items) {
        this.items = items;
    }
}

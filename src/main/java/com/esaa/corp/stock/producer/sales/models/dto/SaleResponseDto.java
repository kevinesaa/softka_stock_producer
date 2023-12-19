package com.esaa.corp.stock.producer.sales.models.dto;

import java.math.BigDecimal;
import java.util.List;

public class SaleResponseDto {

    private String saleId;
    private List<SaleSingeItemResponseDto> items;
    private BigDecimal total;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<SaleSingeItemResponseDto> getItems() {
        return items;
    }

    public void setItems(List<SaleSingeItemResponseDto> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

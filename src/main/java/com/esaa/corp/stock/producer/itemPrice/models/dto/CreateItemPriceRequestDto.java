package com.esaa.corp.stock.producer.itemPrice.models.dto;

import com.esaa.corp.stock.producer._commons.models.database.Item;

import java.math.BigDecimal;

public class CreateItemPriceRequestDto {

    private String itemId;
    private String priceName;
    private Long minUnits;
    private BigDecimal unitPrice;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Long getMinUnits() {
        return minUnits;
    }

    public void setMinUnits(Long minUnits) {
        this.minUnits = minUnits;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}

package com.esaa.corp.stock.producer.itemPrice.models.dto;

import java.math.BigDecimal;

public class CreateItemPriceRequestDto {


    private String itemId;
    private Integer priceTypeCode;
    private String priceName;
    private Long minUnits;
    private BigDecimal pricePerUnit;

    public Integer getPriceTypeCode() {
        return priceTypeCode;
    }

    public void setPriceTypeCode(Integer priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }


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

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}

package com.esaa.corp.stock.producer.itemPrice.models.dto;

import java.math.BigDecimal;

public class CreateItemPriceResponseDto {

    private String priceId;
    private Integer priceTypeCode;
    private String priceName;
    private Long minUnit;
    private String itemId;
    private String itemName;
    private String itemCode;
    private BigDecimal pricePerUnit;

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public Integer getPriceTypeCode() {
        return priceTypeCode;
    }

    public void setPriceTypeCode(Integer priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Long getMinUnit() {
        return minUnit;
    }

    public void setMinUnit(Long minUnit) {
        this.minUnit = minUnit;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }
}

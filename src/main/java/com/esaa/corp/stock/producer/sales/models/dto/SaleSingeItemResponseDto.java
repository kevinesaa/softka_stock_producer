package com.esaa.corp.stock.producer.sales.models.dto;

import java.math.BigDecimal;

public class SaleSingeItemResponseDto {

    private String itemId;
    private String itemName;
    private String itemCode;
    private Long saleQuantity;
    private BigDecimal totalAmount;
    private BigDecimal pricePerUnit;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal amount) {
        this.totalAmount = amount;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }
}

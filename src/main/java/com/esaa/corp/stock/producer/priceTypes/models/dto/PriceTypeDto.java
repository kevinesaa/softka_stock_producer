package com.esaa.corp.stock.producer.priceTypes.models.dto;

public class PriceTypeDto {


    private Integer priceTypeCode;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypePriceCode(Integer priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    public Integer getPriceTypeCode() {
        return priceTypeCode;
    }
}

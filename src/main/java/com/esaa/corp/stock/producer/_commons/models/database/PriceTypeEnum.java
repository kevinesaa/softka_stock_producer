package com.esaa.corp.stock.producer._commons.models.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum PriceTypeEnum implements Serializable {

    RETAIL_PRICE(1,"RETAIL_PRICE"),
    WHOLESALE_PRICE (2,"WHOLESALE_PRICE");

    private final int priceCode;
    private final String name;
    private final PriceTypeWrapper wrapper;

    private static final Map<Integer,PriceTypeEnum> PRICE_TYPE_ENUM_MAP_BY_ID;

    static{
        PRICE_TYPE_ENUM_MAP_BY_ID = new HashMap<>();
    }

    PriceTypeEnum(final int priceCode,final String name) {
        this.priceCode = priceCode;
        this.name = name;
        this.wrapper = new PriceTypeWrapper(priceCode,name);
    }

    public Integer getPriceCode() {
        return priceCode;
    }

    public String getName() {
        return name;
    }

    public PriceTypeWrapper getWrapper() {
        return this.wrapper;
    }

    public static PriceTypeEnum searchByPriceCode(final int priceCode) {

        if(PRICE_TYPE_ENUM_MAP_BY_ID.isEmpty()) {
            for( PriceTypeEnum it :PriceTypeEnum.values()) {
                PRICE_TYPE_ENUM_MAP_BY_ID.put(it.getPriceCode(),it);
            }
        }
        return PRICE_TYPE_ENUM_MAP_BY_ID.get(priceCode);
    }

}

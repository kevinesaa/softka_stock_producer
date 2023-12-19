package com.esaa.corp.stock.producer._commons.models.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum PriceTypeEnum implements Serializable {

    RETAIL_PRICE(1,"DETAL"),
    WHOLESALE_PRICE (2,"MAYOR");

    private final int id;
    private final String name;
    private final PriceTypeWrapper wrapper;

    private static final Map<Integer,PriceTypeEnum> PRICE_TYPE_ENUM_MAP_BY_ID;

    static{
        PRICE_TYPE_ENUM_MAP_BY_ID = new HashMap<>();
    }

    PriceTypeEnum(final int id,final String name) {
        this.id = id;
        this.name = name;
        this.wrapper = new PriceTypeWrapper(id,name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PriceTypeWrapper getWrapper() {
        return this.wrapper;
    }

    public static PriceTypeEnum searchById(final int id) {

        if(PRICE_TYPE_ENUM_MAP_BY_ID.isEmpty()) {
            for( PriceTypeEnum it :PriceTypeEnum.values()) {
                PRICE_TYPE_ENUM_MAP_BY_ID.put(it.getId(),it);
            }
        }
        return PRICE_TYPE_ENUM_MAP_BY_ID.get(id);
    }

}

package com.esaa.corp.stock.producer._commons.models.database;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document("price_types")
public class PriceTypeWrapper implements Serializable {

    @Id
    private String id;
    @Indexed(unique=true)
    private Integer priceTypeCode;
    @Indexed(unique=true)
    private String name;

    public PriceTypeWrapper() {
    }

    public PriceTypeWrapper(Integer priceTypeCode, String name) {
        this.priceTypeCode = priceTypeCode;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPriceTypeCode() {
        return priceTypeCode;
    }

    public void setPriceTypeCode(Integer priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceTypeWrapper that = (PriceTypeWrapper) o;
        return Objects.equals(priceTypeCode, that.priceTypeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceTypeCode);
    }
}

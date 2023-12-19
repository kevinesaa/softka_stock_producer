package com.esaa.corp.stock.producer._commons.models.database;


import java.io.Serializable;
import java.util.Objects;

public class PriceTypeWrapper implements Serializable {

    //@Indexed(unique=true)
    private Integer id;
    //@Indexed(unique=true)
    private String name;

    public PriceTypeWrapper() {
    }

    public PriceTypeWrapper(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.esaa.corp.stock.producer._commons.models.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Sale implements Serializable {

    private String id;
    private List<SaleDetail> items;
    private BigDecimal total;

    private String itemPriceId;
    private String priceTypeName;
    private PriceTypeWrapper priceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SaleDetail> getItems() {
        return items;
    }

    public void setItems(List<SaleDetail> items) {
        this.items = items;
        getTotal();
    }

    public BigDecimal getTotal() {
        if(total == null && items != null && !items.isEmpty()) {
            total = items.stream().map(SaleDetail::getDetailTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getItemPriceId() {
        return itemPriceId;
    }

    public void setItemPriceId(String itemPriceId) {
        this.itemPriceId = itemPriceId;
    }

    public PriceTypeWrapper getPriceType() {
        return priceType;
    }

    public void setPriceType(PriceTypeWrapper priceType) {
        this.priceType = priceType;
    }

    public void setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType.getWrapper();
    }

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.esaa.corp.stock.producer._commons.models.database;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemPrice {

    //@Id
    private String id;
    private String itemId;
    private String priceName;
    private Long minUnits;
    private BigDecimal unitPrice;
    private Item item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPrice itemPrice = (ItemPrice) o;
        return Objects.equals(id, itemPrice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

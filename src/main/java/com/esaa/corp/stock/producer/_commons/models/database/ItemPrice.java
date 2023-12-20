package com.esaa.corp.stock.producer._commons.models.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Document
public class ItemPrice implements Serializable {

    @Id
    private String id;
    @Indexed(unique=true)
    private String priceCode;
    private Integer typePriceCode;
    private String itemId;
    private PriceTypeWrapper priceType;
    private String priceName;
    private Long minUnits;
    private BigDecimal pricePerUnit;
    private Item item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getTypePriceCode() {
        return typePriceCode;
    }

    public void setTypePriceCode(Integer typePriceCode) {
        this.typePriceCode = typePriceCode;
    }

    public PriceTypeWrapper getPriceType() {
        return priceType;
    }

    public PriceTypeEnum getPriceTypeAsEnum() {
        return PriceTypeEnum.searchByPriceCode(this.priceType.getPriceTypeCode());
    }

    public void setPriceType(PriceTypeWrapper priceType) {

        this.priceType = priceType;
    }
    public void setPriceType(PriceTypeEnum priceType) {
        this.priceType = priceType.getWrapper();
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

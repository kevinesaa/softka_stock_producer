package com.esaa.corp.stock.producer._commons.models.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SaleDetail implements Serializable {

    private String itemId;
    private String itemCode;
    private String itemName;

    private String saleDetailId;
    private String saleId;
    private Long saleQuantity;
    private BigDecimal pricePerUnit;
    private BigDecimal detailTotal;

    private String itemPriceId;
    private PriceTypeWrapper priceType;
    private String priceTypeName;
    private Long minUnitsPriceType;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSaleDetailId() {
        return saleDetailId;
    }

    public void setSaleDetailId(String saleDetailId) {
        this.saleDetailId = saleDetailId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Long getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
        getDetailTotal();
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        getDetailTotal();
    }

    public BigDecimal getDetailTotal() {
        if(detailTotal == null && pricePerUnit != null && saleQuantity != null) {
            this.detailTotal = pricePerUnit.multiply(BigDecimal.valueOf(saleQuantity));
        }
        return detailTotal;
    }

    public void setDetailTotal(BigDecimal detailTotal) {
        this.detailTotal = detailTotal;
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

    public Long getMinUnitsPriceType() {
        return minUnitsPriceType;
    }

    public void setMinUnitsPriceType(Long minUnitsPriceType) {
        this.minUnitsPriceType = minUnitsPriceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleDetail that = (SaleDetail) o;
        return Objects.equals(saleDetailId, that.saleDetailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleDetailId);
    }
}

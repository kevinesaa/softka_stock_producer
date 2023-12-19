package com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement;

public class SingleBatchItemRequestDto {

    private String itemId;
    private Long quantity;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

package com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement;

public class CreateSingleMovementResponseDto {

    private String movementId;
    private String batchId;
    private String reason;
    private Long movementQuantity;
    private String itemId;
    private String code;
    private String name;
    private Long itemQuantity;

    public String getMovementId() {
        return movementId;
    }

    public void setMovementId(String movementId) {
        this.movementId = movementId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getMovementQuantity() {
        return movementQuantity;
    }

    public void setMovementQuantity(Long movementQuantity) {
        this.movementQuantity = movementQuantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}

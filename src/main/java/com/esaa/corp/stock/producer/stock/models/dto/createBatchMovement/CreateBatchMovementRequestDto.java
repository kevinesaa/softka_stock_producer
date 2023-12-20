package com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement;

import java.util.List;

public class CreateBatchMovementRequestDto {

    private String reason;
    private List<SingleBatchItemRequestDto> items;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<SingleBatchItemRequestDto> getItems() {
        return items;
    }

    public void setItems(List<SingleBatchItemRequestDto> items) {
        this.items = items;
    }
}

package com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;

import java.util.List;

public class CreateBatchMovementResponseDto {

    private String batchId;
    private String reason;
    private Long completedMovements;
    private Long failedMovements;
    private List<CreateSingleMovementResponseDto> items;

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

    public Long getCompletedMovements() {
        return completedMovements;
    }

    public void setCompletedMovements(Long completedMovements) {
        this.completedMovements = completedMovements;
    }

    public Long getFailedMovements() {
        return failedMovements;
    }

    public void setFailedMovements(Long failedMovements) {
        this.failedMovements = failedMovements;
    }

    public List<CreateSingleMovementResponseDto> getItems() {
        return items;
    }

    public void setItems(List<CreateSingleMovementResponseDto> items) {
        this.items = items;
    }
}

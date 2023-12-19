package com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement;

import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;

public class SingleBatchItemResponseDto extends CreateSingleMovementResponseDto {

    private boolean failed;
    private String failedMessage;

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getFailedMessage() {
        return failedMessage;
    }

    public void setFailedMessage(String failedMessage) {
        this.failedMessage = failedMessage;
    }
}

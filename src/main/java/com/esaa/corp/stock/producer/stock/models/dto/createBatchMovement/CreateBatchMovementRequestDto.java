package com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement;

import java.util.List;

public class CreateBatchMovementRequestDto {

    private String reason;
    private List<SingleBatchItemRequestDto> items;
}

package com.esaa.corp.stock.producer.stock.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Batch;
import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.CreateBatchMovementResponseDto;
import com.esaa.corp.stock.producer.stock.models.dto.createBatchMovement.SingleBatchItemRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;

import java.util.List;

public class CreateBatchStockMapper {

    public ItemMovement itemRequestToItemMovementDb(SingleBatchItemRequestDto itemRequestDto) {
        final ItemMovement movement = new ItemMovement();
        movement.setItemId(itemRequestDto.getItemId());
        movement.setQuantity(itemRequestDto.getQuantity());
        return movement;
    }

    public Batch batchRequestToBachDb(final CreateBatchMovementRequestDto batchRequest) {
        final Batch batch = new Batch();
        final List<ItemMovement> items = batchRequest.getItems()
                .stream()
                .map(this::itemRequestToItemMovementDb)
                .peek(item -> item.setReason(batchRequest.getReason()))
                .toList();
        batch.setReason(batchRequest.getReason());
        batch.setItems(items);
        return batch;
    }

    public CreateSingleMovementResponseDto dbMovementToResponseMovement(ItemMovement itemMovement) {
        CreateSingleMovementResponseDto singleMovementResponseDto = new CreateSingleMovementResponseDto() ;
        final Item item = itemMovement.getItem();

        singleMovementResponseDto.setBatchId(itemMovement.getBatchId());


        singleMovementResponseDto.setMovementId(itemMovement.getId());
        singleMovementResponseDto.setMovementQuantity(itemMovement.getQuantity());
        singleMovementResponseDto.setReason(itemMovement.getReason());

        singleMovementResponseDto.setItemId(item.getId());
        singleMovementResponseDto.setItemCode(item.getCode());
        singleMovementResponseDto.setItemName(item.getName());
        singleMovementResponseDto.setItemQuantity(item.getQuantity());

        return singleMovementResponseDto;
    }

    public CreateBatchMovementResponseDto batchDbModelToResponseModel(Batch batch) {
        final CreateBatchMovementResponseDto response = new CreateBatchMovementResponseDto();
        response.setBatchId(batch.getId());
        response.setReason(batch.getReason());

        response.setItems(batch.getItems().stream()
                .map(this::dbMovementToResponseMovement)
                .toList());

        return response;
    }
}

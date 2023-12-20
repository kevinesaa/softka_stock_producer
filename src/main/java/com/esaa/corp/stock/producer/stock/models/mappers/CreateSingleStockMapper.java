package com.esaa.corp.stock.producer.stock.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.createSingleMovement.CreateSingleMovementResponseDto;

public class CreateSingleStockMapper {

    public ItemMovement requestToDbModel(final CreateSingleMovementRequestDto requestModel) {
        final ItemMovement movement = new ItemMovement();
        movement.setItemId(requestModel.getItemId());
        movement.setReason(requestModel.getReason());
        movement.setQuantity(requestModel.getQuantity());
        return movement;
    }

    public CreateSingleMovementResponseDto dbToResponseModel(final ItemMovement movement) {
        final CreateSingleMovementResponseDto response = new CreateSingleMovementResponseDto();
        final Item item = movement.getItem();

        response.setItemId(item.getId());
        response.setItemName(item.getName());
        response.setItemCode(item.getCode());
        response.setItemQuantity(item.getQuantity());

        response.setMovementId(movement.getId());
        response.setReason(movement.getReason());
        response.setMovementQuantity(movement.getQuantity());
        return response;
    }
}

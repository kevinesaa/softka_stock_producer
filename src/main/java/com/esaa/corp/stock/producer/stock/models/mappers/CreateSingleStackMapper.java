package com.esaa.corp.stock.producer.stock.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.Item;
import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.CreateSingleMovementResponseDto;

public class CreateSingleStackMapper {

    public ItemMovement requestToDbModel(final CreateSingleMovementRequestDto requestModel) {
        final ItemMovement movement = new ItemMovement();
        movement.setItemId(requestModel.getItemId());
        movement.setReason(requestModel.getReason());
        return movement;
    }

    public CreateSingleMovementResponseDto dbToResponseModel(final ItemMovement movement) {
        final CreateSingleMovementResponseDto response = new CreateSingleMovementResponseDto();
        final Item item = movement.getItem();

        response.setItemId(item.getId());
        response.setName(item.getName());
        response.setCode(item.getCode());
        response.setItemQuantity(item.getQuantity());

        response.setMovementId(movement.getId());
        response.setReason(movement.getReason());
        response.setMovementQuantity(movement.getQuantity());
        return response;
    }
}

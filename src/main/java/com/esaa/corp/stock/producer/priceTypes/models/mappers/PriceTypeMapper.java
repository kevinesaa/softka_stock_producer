package com.esaa.corp.stock.producer.priceTypes.models.mappers;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeWrapper;
import com.esaa.corp.stock.producer.priceTypes.models.dto.PriceTypeDto;

public class PriceTypeMapper {
    
    public PriceTypeDto dbModelToResponseDto(PriceTypeWrapper model)
    {
        final PriceTypeDto response = new PriceTypeDto();
        response.setTypePriceCode(model.getPriceTypeCode());
        response.setName(model.getName());
        return response;
    }
}

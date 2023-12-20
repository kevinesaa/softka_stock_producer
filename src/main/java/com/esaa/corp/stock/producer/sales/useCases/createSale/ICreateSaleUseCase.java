package com.esaa.corp.stock.producer.sales.useCases.createSale;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeEnum;
import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateSaleUseCase {

    Mono<SaleResponseDto> apply(final PriceTypeEnum priceTypeEnum,final SaleRequestDto saleRequestDto);
}

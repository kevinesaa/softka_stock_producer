package com.esaa.corp.stock.producer.sales.useCases.createWholeSale;

import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateWholeSaleUseCase {

    Mono<SaleResponseDto> apply(final SaleRequestDto saleRequestDto);
}

package com.esaa.corp.stock.producer.sales.useCases.createReatilSale;

import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import reactor.core.publisher.Mono;

public interface ICreateRetailSaleUseCase {

    Mono<SaleResponseDto> apply(final SaleRequestDto saleRequestDto);
}

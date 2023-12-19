package com.esaa.corp.stock.producer.stock.useCases.getStockByPages;

import com.esaa.corp.stock.producer._commons.models.dto.PageRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.StockPageResponseDto;
import reactor.core.publisher.Mono;


public interface IGetStockByPageUseCase {

     Mono<StockPageResponseDto> getItems(PageRequestDto page);
}

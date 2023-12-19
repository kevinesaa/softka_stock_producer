package com.esaa.corp.stock.producer.stock.useCases.getStockByPages;

import com.esaa.corp.stock.producer._commons.models.dto.PageRequestDto;
import com.esaa.corp.stock.producer.stock.models.dto.StockPageResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetStockByPageUseCase implements IGetStockByPageUseCase {


     @Override
     public Mono<StockPageResponseDto> getItems(PageRequestDto page) {

          return Mono.just(new StockPageResponseDto());
     }
}

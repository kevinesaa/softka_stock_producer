package com.esaa.corp.stock.producer.stock.useCases.getStockByPages;
//import org.springframework.data.domain.PageRequest;

import com.esaa.corp.stock.producer._commons.models.dto.PageRequestDto;
import com.esaa.corp.stock.producer._commons.models.dto.PageResponseModel;
import com.esaa.corp.stock.producer._commons.models.dto.PageResponseWrapperDto;
import com.esaa.corp.stock.producer.stock.models.dto.ItemStockResponseDto;
import com.esaa.corp.stock.producer.stock.models.dto.StockPageResponseDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class GetStockByPageUseCase implements IGetStockByPageUseCase {


     @Override
     public Mono<StockPageResponseDto> getItems(PageRequestDto page) {
          //PageRequest.of(page, size);
          return Mono.just(new StockPageResponseDto(Collections.EMPTY_LIST,new PageResponseModel(0,1,30)));
     }
}

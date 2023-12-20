package com.esaa.corp.stock.producer.stock.useCases.getStockByPages;
//import org.springframework.data.domain.PageRequest;

import com.esaa.corp.stock.producer._commons.models.dto.PageRequestDto;
import com.esaa.corp.stock.producer._commons.models.dto.PageResponseModel;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.stock.models.dto.getStockItemsByPage.StockPageResponseDto;
import com.esaa.corp.stock.producer.stock.models.mappers.StockItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetStockByPageUseCase implements IGetStockByPageUseCase {

     @Autowired
     private IItemRepository itemRepository;

     @Autowired
     private StockItemMapper stockItemMapper;

     @Override
     public Mono<StockPageResponseDto> getItems(final PageRequestDto page) {

          final Pageable pageable = PageRequest.of(page.getPage(), page.getSize());
          
          return itemRepository
                  .findAll(pageable.getSort())
                  .map(item -> stockItemMapper.dbModelToResponseModel(item))
                  .collectList()
                  .zipWith(itemRepository.count())
                  .map(tuple -> {
                       final PageResponseModel pagination = new PageResponseModel(tuple.getT2(), page.getPage(), page.getSize());
                       return new StockPageResponseDto(tuple.getT1(),pagination);
                  });
     }
}

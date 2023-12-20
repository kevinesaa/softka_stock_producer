package com.esaa.corp.stock.producer.sales.useCases.createReatilSale;

import com.esaa.corp.stock.producer._commons.models.database.*;
import com.esaa.corp.stock.producer.itemPrice.drivenAdapters.respositories.IPriceRepository;
import com.esaa.corp.stock.producer.items.drivenAdapters.respositories.IItemRepository;
import com.esaa.corp.stock.producer.sales.drivenAdapters.respositories.ISaleDetailRepository;
import com.esaa.corp.stock.producer.sales.drivenAdapters.respositories.ISaleRepository;
import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleSingleItemRequestDto;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import com.esaa.corp.stock.producer.sales.useCases.createSale.CreateSaleUseCase;
import com.esaa.corp.stock.producer.stock.drivenAdapters.respositories.IStockSingleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CreateRetailSaleUseCase implements ICreateRetailSaleUseCase {

   
    @Autowired
    private CreateSaleUseCase createSaleUseCase;

    @Override
    public Mono<SaleResponseDto> apply(final SaleRequestDto saleRequestDto) {

        return createSaleUseCase.apply(PriceTypeEnum.RETAIL_PRICE,saleRequestDto);
    }

}

package com.esaa.corp.stock.producer.sales.useCases.createWholeSale;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeEnum;
import com.esaa.corp.stock.producer._commons.models.database.Sale;
import com.esaa.corp.stock.producer._commons.models.database.SaleDetail;
import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import com.esaa.corp.stock.producer.sales.useCases.createSale.CreateSaleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class CreateWholeSaleUseCase implements ICreateWholeSaleUseCase {

    @Autowired
    private CreateSaleUseCase createSaleUseCase;

    @Override
    public Mono<SaleResponseDto> apply(final SaleRequestDto saleRequestDto) {

        return createSaleUseCase.apply(PriceTypeEnum.WHOLESALE_PRICE,saleRequestDto);
    }
}

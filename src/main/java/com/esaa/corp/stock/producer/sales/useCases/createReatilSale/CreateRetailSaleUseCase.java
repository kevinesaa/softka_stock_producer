package com.esaa.corp.stock.producer.sales.useCases.createReatilSale;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeEnum;
import com.esaa.corp.stock.producer._commons.models.database.Sale;
import com.esaa.corp.stock.producer._commons.models.database.SaleDetail;
import com.esaa.corp.stock.producer.sales.models.dto.SaleRequestDto;
import com.esaa.corp.stock.producer.sales.models.dto.SaleResponseDto;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateRetailSaleUseCase implements ICreateRetailSaleUseCase{

    @Autowired
    private CreateSaleMapper mapper;

    @Override
    public Mono<SaleResponseDto> apply(final SaleRequestDto saleRequestDto) {

        final PriceTypeEnum priceTypeEnum = PriceTypeEnum.RETAIL_PRICE;
        final List<SaleDetail> saleDetailItems = saleRequestDto
                .getItems()
                .stream()
                .map(item -> mapper.singleItemRequestModelToDbModel(item))
                .peek(item->item.setPriceType(priceTypeEnum))
                .toList();

        //save sale
        final Sale sale = new Sale();
        sale.setPriceType(priceTypeEnum);
        sale.setItems(saleDetailItems);
        //

        final SaleResponseDto response = mapper.saleDbModelToResponseModel(sale);
        return Mono.just(response);
    }
}

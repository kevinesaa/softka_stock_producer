package com.esaa.corp.stock.producer._config;

import com.esaa.corp.stock.producer.itemPrice.models.mappers.CreateItemPriceMapper;
import com.esaa.corp.stock.producer.items.models.mappers.CreateItemMapper;
import com.esaa.corp.stock.producer.priceTypes.models.mappers.PriceTypeMapper;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateBatchStockMapper;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateSingleStockMapper;
import com.esaa.corp.stock.producer.stock.models.mappers.StockItemMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CreateItemMapper createItemMapper(){
        return new CreateItemMapper();
    }

    @Bean
    public CreateSingleStockMapper createSingleStackMapper() {
        return new CreateSingleStockMapper();
    }

    @Bean
    public CreateItemPriceMapper createItemPriceMapper() {
        return new CreateItemPriceMapper();
    }

    @Bean
    public CreateSaleMapper createSaleMapper() {
        return new CreateSaleMapper();
    }

    @Bean
    public StockItemMapper createStockItemMapper() {
        return new StockItemMapper();
    }

    @Bean
    public CreateBatchStockMapper createBatchStockMapper() {
        return new CreateBatchStockMapper();
    }

    @Bean
    public PriceTypeMapper createPriceTypeMapper() {
        return new PriceTypeMapper();
    }
}

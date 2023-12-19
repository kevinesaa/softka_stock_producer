package com.esaa.corp.stock.producer._config;

import com.esaa.corp.stock.producer.itemPrice.models.mappers.CreateItemPriceMapper;
import com.esaa.corp.stock.producer.items.models.mappers.CreateItemMapper;
import com.esaa.corp.stock.producer.sales.models.mappers.CreateSaleMapper;
import com.esaa.corp.stock.producer.stock.models.mappers.CreateSingleStackMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CreateItemMapper createItemMapper(){
        return new CreateItemMapper();
    }

    @Bean
    public CreateSingleStackMapper createSingleStackMapper() {
        return new CreateSingleStackMapper();
    }

    @Bean
    public CreateItemPriceMapper createItemPriceMapper() {
        return new CreateItemPriceMapper();
    }

    @Bean
    public CreateSaleMapper createSaleMapper() {
        return new CreateSaleMapper();
    }
}

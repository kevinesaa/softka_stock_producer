package com.esaa.corp.stock.producer.priceTypes.handlers.command;

import com.esaa.corp.stock.producer.priceTypes.useCases.loadInitialData.ILoadInitialDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PriceTypeCommand implements CommandLineRunner
{

    @Autowired
    private ILoadInitialDataUseCase useCase;

    @Override
    public void run(String... args) throws Exception {
        useCase.execute();
    }
}

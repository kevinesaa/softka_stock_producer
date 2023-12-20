package com.esaa.corp.stock.producer.priceTypes.useCases.loadInitialData;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeEnum;
import com.esaa.corp.stock.producer.priceTypes.drivenAdapters.respositories.IPriceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Component
public class LoadInitialDataUseCase implements ILoadInitialDataUseCase {


    @Autowired
    private IPriceTypeRepository priceTypeRepository;

    @Override
    public void execute() {
        Flux.fromStream(
                Arrays.stream(PriceTypeEnum.values()))
                .map(i -> {
                  return priceTypeRepository
                          .findByPriceTypeCode(i.getPriceCode())
                          .switchIfEmpty(priceTypeRepository.save(i.getWrapper()) );
                })
                .flatMap(i -> i)
                .subscribe(System.out::println);
    }
}

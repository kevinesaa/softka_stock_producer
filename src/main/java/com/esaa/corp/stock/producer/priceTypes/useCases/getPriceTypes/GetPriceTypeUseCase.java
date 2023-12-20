package com.esaa.corp.stock.producer.priceTypes.useCases.getPriceTypes;

import com.esaa.corp.stock.producer.priceTypes.drivenAdapters.respositories.IPriceTypeRepository;
import com.esaa.corp.stock.producer.priceTypes.models.dto.PriceTypeDto;
import com.esaa.corp.stock.producer.priceTypes.models.mappers.PriceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetPriceTypeUseCase implements IGetPriceTypeUseCase{

    @Autowired
    private IPriceTypeRepository priceTypeRepository;
    @Autowired
    private PriceTypeMapper mapper;

    @Override
    public Flux<PriceTypeDto> getPriceTypes() {

        return priceTypeRepository.findAll().map(mapper::dbModelToResponseDto);
    }
}

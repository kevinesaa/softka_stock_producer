package com.esaa.corp.stock.producer.priceTypes.drivenAdapters.respositories;

import com.esaa.corp.stock.producer._commons.models.database.PriceTypeWrapper;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IPriceTypeRepository extends ReactiveMongoRepository<PriceTypeWrapper,String> {

    Mono<PriceTypeWrapper> findByPriceTypeCode(Integer priceTypeCode);
}

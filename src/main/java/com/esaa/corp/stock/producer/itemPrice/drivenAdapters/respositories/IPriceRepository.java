package com.esaa.corp.stock.producer.itemPrice.drivenAdapters.respositories;

import com.esaa.corp.stock.producer._commons.models.database.ItemPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IPriceRepository extends ReactiveMongoRepository<ItemPrice,String> {

    Mono<ItemPrice> findByPriceCode(String priceCode);
}

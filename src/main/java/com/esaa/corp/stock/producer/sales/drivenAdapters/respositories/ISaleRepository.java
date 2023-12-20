package com.esaa.corp.stock.producer.sales.drivenAdapters.respositories;

import com.esaa.corp.stock.producer._commons.models.database.Sale;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ISaleRepository extends ReactiveMongoRepository<Sale,String> {
}

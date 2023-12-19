package com.esaa.corp.stock.producer.stock.models.database;

import com.esaa.corp.stock.producer._commons.models.database.Batch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBatchRepository extends ReactiveMongoRepository<Batch,String> {
}

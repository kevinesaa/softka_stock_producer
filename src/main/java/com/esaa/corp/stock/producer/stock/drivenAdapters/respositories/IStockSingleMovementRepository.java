package com.esaa.corp.stock.producer.stock.drivenAdapters.respositories;

import com.esaa.corp.stock.producer._commons.models.database.ItemMovement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IStockSingleMovementRepository extends ReactiveMongoRepository<ItemMovement,String> {
}

package com.esaa.corp.stock.producer.sales.drivenAdapters.respositories;

import com.esaa.corp.stock.producer._commons.models.database.SaleDetail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ISaleDetailRepository extends ReactiveMongoRepository<SaleDetail,String> {
}

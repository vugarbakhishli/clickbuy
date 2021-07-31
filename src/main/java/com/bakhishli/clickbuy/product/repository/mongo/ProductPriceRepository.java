package com.bakhishli.clickbuy.product.repository.mongo;

import com.bakhishli.clickbuy.product.domain.ProductPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends ReactiveMongoRepository<ProductPrice, String> {
}

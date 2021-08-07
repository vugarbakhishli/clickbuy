package com.bakhishli.clickbuy.product.repository.mongo.product;

import com.bakhishli.clickbuy.product.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}

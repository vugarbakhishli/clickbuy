package com.bakhishli.clickbuy.product.repository.mongo.category;

import com.bakhishli.clickbuy.product.domain.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}

package com.bakhishli.clickbuy.account.repository;

import com.bakhishli.clickbuy.account.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}

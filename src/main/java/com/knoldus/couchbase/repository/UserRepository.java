package com.knoldus.couchbase.repository;

import com.knoldus.couchbase.model.User;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCouchbaseRepository<User, String> {

    Mono<User> findByFirstNameAndCity(String firstName, String city);

    Mono<User> save(User user);
}



package com.mintic.reto4.repository.crud;

import java.util.Optional;

import com.mintic.reto4.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudRepository extends MongoRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}

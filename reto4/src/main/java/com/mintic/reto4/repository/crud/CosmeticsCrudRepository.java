package com.mintic.reto4.repository.crud;

import com.mintic.reto4.model.Cosmetics;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CosmeticsCrudRepository extends MongoRepository<Cosmetics, String> {

}

package com.mintic.reto4.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto4.model.Cosmetics;
import com.mintic.reto4.repository.crud.CosmeticsCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CosmeticsRepository {
    @Autowired
    private CosmeticsCrudRepository supplementsInterface;

    public List<Cosmetics> getAll() {
        return supplementsInterface.findAll();
    }

    public Optional<Cosmetics> getSupplement(String reference) {
        return supplementsInterface.findById(reference);
    }
    public Cosmetics create(Cosmetics supplements) {
        return supplementsInterface.save(supplements);
    }

    public void update(Cosmetics supplements) {
        supplementsInterface.save(supplements);
    }

    public void delete(Cosmetics supplements) {
        supplementsInterface.delete(supplements);
    }

}

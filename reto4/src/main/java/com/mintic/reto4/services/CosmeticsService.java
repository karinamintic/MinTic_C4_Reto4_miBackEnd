package com.mintic.reto4.services;

import java.util.List;
import java.util.Optional;

import com.mintic.reto4.model.Cosmetics;
import com.mintic.reto4.repository.CosmeticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosmeticsService {
    @Autowired
    private CosmeticsRepository cosmeticsRepository;

    public List<Cosmetics> getAll() {
        return cosmeticsRepository.getAll();
    }

   public Optional<Cosmetics> getSupplement(String reference) {
        return cosmeticsRepository.getSupplement(reference);
    }

    public Cosmetics save(Cosmetics accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cosmeticsRepository.create(accesory);
        }
    }

    public Cosmetics update(Cosmetics accesory) {

        if (accesory.getReference() != null) {
            Optional<Cosmetics> accesoryDb = cosmeticsRepository.getSupplement(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cosmeticsRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(accesory -> {
            cosmeticsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

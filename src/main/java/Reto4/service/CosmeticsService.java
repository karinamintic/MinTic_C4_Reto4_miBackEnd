/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.service;

import Reto4.model.Cosmetics;
import Reto4.repository.CosmeticsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CosmeticsService {
    
    @Autowired
    private CosmeticsRepository cosmeticsRepository;

    public List<Cosmetics> getAll() {
        return cosmeticsRepository.getAll();
    }

   public Optional<Cosmetics> getCosmetic(String reference) {
        return cosmeticsRepository.getCosmetic(reference);
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
            Optional<Cosmetics> accesoryDb = cosmeticsRepository.getCosmetic(accesory.getReference());
            if (accesoryDb.isPresent()) {
                
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
        Boolean aBoolean = getCosmetic(reference).map(accesory -> {
            cosmeticsRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.repository;

import Reto4.model.Cosmetics;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto4.repository.Interface.CosmeticsInterface;


@Repository
public class CosmeticsRepository {
    
    @Autowired
    private CosmeticsInterface cosmeticsInterface;

    public List<Cosmetics> getAll() {
        return cosmeticsInterface.findAll();
    }

    public Optional<Cosmetics> getCosmetic(String reference) {
        return cosmeticsInterface.findById(reference);
    }
    public Cosmetics create(Cosmetics cosmetics) {
        return cosmeticsInterface.save(cosmetics);
    }

    public void update(Cosmetics cosmetics) {
        cosmeticsInterface.save(cosmetics);
    }
    
    public void delete(Cosmetics cosmetics) {
        cosmeticsInterface.delete(cosmetics);
    }

    public List<Cosmetics> getByPrice(double price){
        return cosmeticsInterface.findByPrice(price);
    }

    public List<Cosmetics> getByDescriptionContains(String description){
        return cosmeticsInterface.findByDescriptionContainingIgnoreCase(description);
    }
    
}

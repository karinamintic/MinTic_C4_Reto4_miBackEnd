/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.controller;

import Reto4.model.Cosmetics;
import Reto4.service.CosmeticsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class CosmeticsController {
    @Autowired
    private CosmeticsService cosmeticsService;
       
    @GetMapping("/all")
    public List<Cosmetics> getAll() {
        return cosmeticsService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Cosmetics> getCosmetics(@PathVariable("reference") String reference) {
        return cosmeticsService.getCosmetic(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics save(@RequestBody Cosmetics supplements) {
        return cosmeticsService.save(supplements);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics update(@RequestBody Cosmetics supplements) {
        return cosmeticsService.update(supplements);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String cosmetics) {
        return cosmeticsService.delete(cosmetics);
    }
   
}

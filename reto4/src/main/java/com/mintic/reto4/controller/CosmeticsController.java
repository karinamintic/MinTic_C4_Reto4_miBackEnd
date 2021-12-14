package com.mintic.reto4.controller;

import java.util.List;
import java.util.Optional;

import com.mintic.reto4.model.Cosmetics;
import com.mintic.reto4.services.CosmeticsService;

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
    public Optional<Cosmetics> getSupplement(@PathVariable("reference") String reference) {
        return cosmeticsService.getSupplement(reference);
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
    public boolean delete(@PathVariable("reference") String supplements) {
        return cosmeticsService.delete(supplements);
    }

}

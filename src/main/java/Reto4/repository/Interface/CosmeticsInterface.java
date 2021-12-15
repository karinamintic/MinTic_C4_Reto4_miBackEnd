/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.repository.Interface;

import Reto4.model.Cosmetics;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CosmeticsInterface extends MongoRepository<Cosmetics, String> {
    
}

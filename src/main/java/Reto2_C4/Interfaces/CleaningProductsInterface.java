/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Interfaces;

/**
 *
 * @author gabrielroa
 */
import Reto2_C4.Model.CleaningProducts;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProductsInterface extends MongoRepository<CleaningProducts, String> {

    public Optional<CleaningProducts> findById(String reference);
    
}

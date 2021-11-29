/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Repository;

import Reto2_C4.Interfaces.CleaningProductsInterface;
import Reto2_C4.Model.CleaningProducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabrielroa
 */
@Repository
public class CleaningProductsRepository {
    @Autowired
    private CleaningProductsInterface repository;

    public List<CleaningProducts> getAll() {
        return repository.findAll();
    }

    public Optional<CleaningProducts> getClothe(String reference) {
        return repository.findById(reference);
    }
    public CleaningProducts create(CleaningProducts clothe) {
        return repository.save(clothe);
    }

    public void update(CleaningProducts clothe) {
        repository.save(clothe);
    }
    
    public void delete(CleaningProducts clothe) {
        repository.delete(clothe);
    }   
}

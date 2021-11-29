/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Services;

import Reto2_C4.Repository.CleaningProductsRepository;
import Reto2_C4.Model.CleaningProducts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabrielroa
 */
@Service
public class CleaningProductsService {
    @Autowired
    private CleaningProductsRepository clotheRepository;
    public List<CleaningProducts> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<CleaningProducts> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public CleaningProducts create(CleaningProducts product) {
        if (product.getReference() == null) {
            return product;
        } else {
            return clotheRepository.create(product);
        }
    }
    public CleaningProducts update(CleaningProducts product) {

        if (product.getReference() != null) {
            Optional<CleaningProducts> productDb = clotheRepository.getClothe(product.getReference());
            if (!productDb.isEmpty()) {
                
                if (product.getBrand()!= null) {
                    productDb.get().setBrand(product.getBrand());
                }
                
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                clotheRepository.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }
     public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(product -> {
            clotheRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

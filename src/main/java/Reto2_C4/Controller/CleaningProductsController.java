/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Controller;

import Reto2_C4.Model.CleaningProducts;
import Reto2_C4.Services.CleaningProductsService;
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

/**
 *
 * @author gabrielroa
 */
@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin("*")
public class CleaningProductsController {
    @Autowired
    private CleaningProductsService productService;
    @GetMapping("/all")
    public List<CleaningProducts> getAll() {
        return productService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<CleaningProducts> getClothe(@PathVariable("reference") String reference) {
        return productService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProducts create(@RequestBody CleaningProducts gadget) {
        return productService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProducts update(@RequestBody CleaningProducts gadget) {
        return productService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return productService.delete(reference);
    } 
}

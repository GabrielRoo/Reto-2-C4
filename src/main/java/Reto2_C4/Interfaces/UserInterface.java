/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Interfaces;

import Reto2_C4.Model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gabrielroa
 */
public interface UserInterface extends MongoRepository <User, Integer> {
    Optional<User> findByEmail (String email);
    Optional <User> findByEmailAndPassword(String email, String password);
}

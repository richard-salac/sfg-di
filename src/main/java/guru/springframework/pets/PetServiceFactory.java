/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.pets;

import org.springframework.stereotype.Service;

/**
 *
 * @author Richard Salac (richard.salac@datera.cz)
 */
public class PetServiceFactory {
    
    public PetService getPetService(String petType){
        switch(petType){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }
}

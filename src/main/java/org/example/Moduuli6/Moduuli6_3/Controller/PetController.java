package org.example.Moduuli6.Moduuli6_3.Controller;

import org.example.Moduuli6.Moduuli6_3.Model.Pet;

public class PetController {
    private Pet pet;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public double getLocationX() {
        return pet.getLocationX();
    }

    public double getLocationY() {
        return pet.getLocationY();
    }


    public void updateLocation() {
        pet.setLocation(getLocationX() +((pet.getTargetX()-getLocationX())/100), getLocationY()+((pet.getTargetY()-getLocationY())/100));
    }

    public void updateTargetLocation(double x, double y) {
        pet.updateTargetLocation(x, y);
    }
}

package factory;

import animals.Animal;
import data.AnimalData;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;

public class AnimalFactory {

    public Animal create(AnimalData animalData) {
        switch(animalData) {
            case CAT:
                return new Cat();
            case DOG:
                return new Dog();
            default:
                return new Duck();
        }
    }
}

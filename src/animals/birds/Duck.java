package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFlying {
    public void say() {
        System.out.println("Кря-кря!");
    }

    public void fly() {
        System.out.println("Я умею летать!");
    }

}

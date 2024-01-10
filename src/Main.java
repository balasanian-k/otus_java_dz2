import animals.Animal;
import animals.birds.IFlying;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;
import validators.NumberValidator;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Animal> animalsList = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();
        NumberValidator numberValidator = new NumberValidator();

        while(true) {
            System.out.println("Ввeдите команду из указанных: add/list/exit");
            String commandStr = scanner.next().toUpperCase(Locale.ROOT).trim();

            if (!commandValidator.isValidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели неверную команду");
                continue;
            }

            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch(commandsData) {
                case ADD:

                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного из указанных: cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase(Locale.ROOT).trim();

                        if (commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                        System.out.println("Вы ввели неверный тип животного");
                    }

                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                    System.out.println("Введите имя животного");
                    animal.setName(scanner.next());

                    System.out.println("Введите возраст животного");
                    animal.setAge(scanner);

                    System.out.println("Введите вес животного");
                    animal.setWeight(scanner);


                    while(true) {
                        System.out.println("Введите окрас животного");
                        String colorStr = scanner.next();

                        if (numberValidator.isNumber(colorStr, Pattern.compile("^[а-яА-Я]+$"))) {
                            animal.setColor(colorStr);
                            break;
                        }
                        System.out.println("Вы ввели неверный окрас животного");
                    }

                    animalsList.add(animal);

                    animal.say();

                    if(animal instanceof IFlying) {
                    ((IFlying)animal).fly();
                    }
                    break;

                case LIST:
                    if(animalsList.isEmpty()) {
                        System.out.println("Объект не создан");
                        continue;
                    }
                    for(Animal animalObj: animalsList) {
                        System.out.println(animalObj.toString());
                    }
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
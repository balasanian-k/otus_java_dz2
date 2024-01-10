package animals;

import validators.NumberValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animal {
    private int age = -1;
    private int weight = -1;
    private String name = "";
    private String color = "";

    private NumberValidator numberValidator = new NumberValidator();

    public void setName(String name) {
        this.name = name;
    }

    private int validateAgeWeightData(Scanner scanner) {
        int data = -1;
        while(true) {
            String ageStr = scanner.next();
            if(numberValidator.isNumber(ageStr, Pattern.compile("^\\d+$"))) {
                data = Integer.parseInt(ageStr);
                if(data > 50 || data <=0) {
                    System.out.println("Ошибочно введен возраст животного");
                    continue;
                }
                break;
            }
            System.out.println("Ошибочно введен возраст животного");
        }
        return data;
    }

    public void setAge(Scanner scanner) {
        this.age = this.validateAgeWeightData(scanner);
    }

    public void setWeight(Scanner scanner) {
        this.weight = this.validateAgeWeightData(scanner);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {

        String yearPadej = getYearPadej();
        if(yearPadej == null) {
            return "Возвраст введен неверно";
        }

        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s!",
                this.name,
                this.age,
                getYearPadej(),
                this.weight,
                this.color
        );
    }

    private String getYearPadej() {

        if (this.age <=0 || this.age > 50) {
            return null;
        }

        if (this.age >=11 && this.age <=19) {
            return "лет";
        }

        int ostatok = this.age % 10;
        if(ostatok == 0 || ostatok >=5) {
            return "лет";
        }

        if(ostatok == 1) {
            return "год";
        }

        return "года";
    }
}

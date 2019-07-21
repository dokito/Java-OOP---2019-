package WildFarm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!input.equals("End")){
            String[] animalTokens = input.split("\\s+");

            String[] foodTokens = scanner.nextLine().split("\\s+");

            Animal animal = produceAnimal(animalTokens);

            Food food = produceFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Food produceFood(String[] foodTokens) {
        String type = foodTokens[0];

        Food food = null;
        try {
            Class foodClass = Class.forName("WildFarm."+type);
            Constructor constructor = foodClass.getConstructor(int.class);
            food = (Food) constructor.newInstance(Integer.parseInt(foodTokens[1]));

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return food;
    }

    private static Animal produceAnimal(String[] animalTokens) {
        Animal animal = null;

        if(animalTokens[0].equals("Mouse")) {
            animal = new Mouse(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
        } else if (animalTokens[0].equals("Zebra")) {
            animal = new Zebra(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
        } else if (animalTokens[0].equals("Cat")) {
            animal = new Cat(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
        } else if (animalTokens[0].equals("Tiger")) {
            animal = new Tiger(animalTokens[1], animalTokens[0], Double.parseDouble(animalTokens[2]), animalTokens[3]);
        }

        return animal;
    }
}

package PolymorphismExercise.WildFarm;

/*
Your task is to create a class hierarchy like the picture below. All the classes except Vegetable, Meat, Mouse, Tiger,
Cat & Zebra should be abstract.

Input should be read from the console. Every even line will contain information about the Animal in following
format: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion}"
If the animal is a cat: "{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} {CatBreed}".

On the odd lines, you will receive information about the food that you should give to the Animal. The line will
consist of FoodType and quantity separated by whitespace.
You should build the logic to determine if the animal is going to eat the provided food. The Mouse and Zebra
should check if the food is Vegetable. If it is they will eat it. Otherwise, you should print a message in the format:
"{AnimalType} are not eating that type of food!". AnimalType to be in the plural.
Cats eat any kind of food, but Tigers accept only Meat. If a Vegetable is provided to a tiger message like the
one above should be printed on the console.
After you read information about the Animal and Food then invoke makeSound() method of the current animal
and then feed it. In the end, print the whole object in the format:
"{AnimalType} [{AnimalName}, {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}]".
If the animal is a cat: "{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight},
{AnimalLivingRegion}, {FoodEaten}]"

Proceed to read information about the next animal/food. The input will continue until you receive "End".
Print all AnimalWeight with two digits after the decimal separator. Use the DecimalFormat class.
Note: consider overriding toString() method.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            // read animal and food data
            String[] animalData = input.split("\\s+");
            String[] foodData = scan.nextLine().split("\\s+");

            // create animal and food
            Animal animal = createAnimal(animalData);
            Food food = createFood(foodData);

            // invoke sound method
            animal.makeSound();
            // invoke eat method -> eat or print error message
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // add the animal to the list
            animals.add(animal);

            input = scan.nextLine();
        }

        // print animals info
        animals.forEach(System.out::println);

    }

    private static Food createFood(String[] foodData) {
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);

        if (foodType.equals("Vegetable")) {
            return new Vegetable(foodQuantity);
        } else {
            return new Meat(foodQuantity);
        }
    }

    private static Animal createAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        switch (animalType) {
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Cat":
                String animalBreed = animalData[4];

                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);

        }
    }
}

package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", super.getType()));
        } else {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("Zebra[%s, %s, %s, %d]",
                super.getName(),
                df.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}

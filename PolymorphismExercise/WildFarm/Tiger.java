package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", super.getType()));
        } else {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("Tiger[%s, %s, %s, %d]",
                super.getName(),
                df.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}

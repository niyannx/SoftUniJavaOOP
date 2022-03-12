package PolymorphismExercise.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private final String breed;

    public Cat(String name, String type, Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("Cat[%s, %s, %s, %s, %d]",
                super.getName(),
                this.getBreed(),
                df.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}

package PolymorphismExercise.WildFarm;

public abstract class Animal {
    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight) {
        this.setName(animalName);
        this.setType(animalType);
        this.setWeight(animalWeight);
        this.foodEaten = 0;
    }

    abstract void makeSound();
    abstract void eat(Food food);

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setType(String type) {
        this.type = Plurals.pluralOfAnimals.get(type);;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }
}

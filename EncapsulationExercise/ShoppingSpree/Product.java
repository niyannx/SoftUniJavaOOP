package EncapsulationExercise.ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    // validate the product's name
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    // validate the product's cost
    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}

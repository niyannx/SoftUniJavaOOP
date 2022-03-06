package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        products = new ArrayList<>();
    }

    // validate the person's name
    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    // validate the person's money
    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        if (this.canAfford(product)) {
            pay(product);
            products.add(product);
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

        // if the deal is successful
        System.out.printf("%s bought %s\n", this.getName(), product.getName());
    }

    private void pay(Product product) {
        this.money = this.money - product.getCost();
    }

    private boolean canAfford(Product product) {
        return this.money >= product.getCost();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getName()).append(" - ");

        if (products.size() != 0) {
            sb.append(products.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else {
            sb.append("Nothing bought");
        }

        return sb.toString();
    }
}

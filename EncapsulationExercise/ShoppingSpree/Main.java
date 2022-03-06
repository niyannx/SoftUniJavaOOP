package EncapsulationExercise.ShoppingSpree;

/*
Create two classes: class Person and class Product. Each person should have a name, money, and a bag of products.
Each product should have a name and cost. The name cannot be an empty string. Be careful about white space in
the name. Money and cost cannot be a negative number.

Person
- name: String
- money: double
- products: List<Product>
+ Person (String, double)
- setName (String): void
- setMoney (double): void
+ buyProduct (Product): void
+ getName(): String

Product
- name: String
- cost: double
+ Product (String, double)
- setCost (double): void
- setName (String): void
+ getName(): String
+ getCost (): double

Create a program in which each command corresponds to a person buying a product. If the person can afford a
product add it to his bag. If a person doesn't have enough money, print an appropriate exception message:
"{Person name} can't afford {Product name}"

On the first two lines, you are given all people and all products. After all, purchases print every person in the order
of appearance and all products that he has bought also in order of appearance. If nothing is bought, print:
"{Person name} - Nothing bought".

Read commands till you find the line with the &quot;END&quot; command. In case of invalid input (negative money exception
message: "Money cannot be negative") or empty name: (empty name exception message "Name cannot be
empty") break the program with an appropriate message.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // read people and product info
        String[] peopleInput = reader.readLine().split(";");
        String[] productsInput = reader.readLine().split(";");

        // lists to keep all the people and all the products
        List<Person> people = readPeopleList(peopleInput);
        List<Product> products = readProductsList(productsInput);

        String input = reader.readLine();

        while (!input.equals("END")) {
            // reading WHO wants to buy WHAT
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];

            // we find the product the person wants to buy (by name search in a different method)
            Product toBuy = findProduct(products, productName);

            // because the toBuy method CAN return null, we check if it does
            if (toBuy != null) {
                // iterate through every person
                for (Person person : people) {
                    // if the current person is the buyer we're searching for
                    if (person.getName().equals(personName)) {
                        // we get him to buy the product
                        try {
                            person.buyProduct(toBuy);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
            }

            input = reader.readLine();
        }

        // print the output - person & products they've bought
        printOutput(people);
    }

    // method for printing the output
    private static void printOutput(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    // finding the product under the name productName
    private static Product findProduct(List<Product> products, String productName) {
        // iterate through products
        for (Product product : products) {
            // if the current products name is the same as the one we're searching for
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // read the list of people
    private static List<Person> readPeopleList(String[] peopleInput) {
        List<Person> people = new ArrayList<>();

        for (String personInfo : peopleInput) {
            String name = personInfo.split("=")[0];
            double money = Double.parseDouble(personInfo.split("=")[1]);

            try {
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return people;
    }

    // read the list of products
    private static List<Product> readProductsList(String[] productsInput) {
        List<Product> products = new ArrayList<>();

        for (String productInfo : productsInput) {
            String name = productInfo.split("=")[0];
            double cost = Double.parseDouble(productInfo.split("=")[1]);

            try {
                Product product = new Product(name, cost);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return products;
    }
}

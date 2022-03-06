package EncapsulationExercise.PizzaCalories;

/*
A Pizza is made of dough and different toppings. You should model a class Pizza which should have a name, dough,
and toppings as fields. Every type of ingredient should have its class.

            Pizza
- name: String
- dough: Dough
- toppings: List<Topping>
+ Pizza (String, int numberOfToppings)
- setToppings(int) : void
- setName(String) : void
+ setDough(Dough) : void
+ getName(): String
+ addTopping (Topping) : void
+ getOverallCalories () : double

Every ingredient has different fields: the dough can be white or wholegrain and in addition, it can be crispy, chewy,
or homemade. The toppings can be of type meat, veggies, cheese, or sauce. Every ingredient should weigh grams
and a method for calculating its calories according to its type. Calories per gram are calculated through modifiers.
Every ingredient has 2 calories per gram as a base and a modifier that gives the exact calories.

            Dough
- flourType: String
- bakingTechnique: String
- weight: double
+ Dough (String, String, double)
- setWeight(double): void
- setFlourType(String): void
- setBakingTechnique(String): void
+ calculateCalories (): double

            Topping
- toppingType: String
- weight: double
+ Topping (String, double)
- setToppingType (String): void
- setWeight (double): void
+ calculateCalories (): double

Your job is to model the classes in such a way that they are properly encapsulated and to provide a public method
for every pizza that calculates its calories according to the ingredients it has.

Dough Modifiers
 White – 1.5;
 Wholegrain – 1.0;
 Crispy – 0.9;
 Chewy – 1.1;
 Homemade – 1.0;

Toppings Modifiers
 Meat – 1.2;
 Veggies – 0.8;
 Cheese – 1.1;
 Sauce – 0.9;

For example, the white dough has a modifier of 1.5, a chewy dough has a modifier of 1.1, which means that a white
chewy dough weighing 100 grams will have (2 * 100) * 1.5 * 1.1 = 330.00 total calories.
For example, meat has a modifier of 1.2, which means that meat weighing 50 grams will have (2 * 50) * 1.2 = 120.00
total calories.

Data Validation must be in the order of the Input Data.
 If an invalid flour type or an invalid baking technique is given an exception is thrown with the message
"Invalid type of dough."
 If dough weight is outside the range [1..200] throw an exception with the message "Dough weight
should be in the range [1..200]."
 If topping is not one of the provided types throw an exception with the message "Cannot place {name
of invalid argument} on top of your pizza."
 If topping weight is outside the range [1..50] throw an exception with the message "{Topping type
name} weight should be in the range [1..50].".
 If the name of the pizza is empty, only whitespace or longer than 15 symbols throw an exception with the
message "Pizza name should be between 1 and 15 symbols.".
 If a number of toppings are outside the range [0..10] throw an exception with the message "Number of
toppings should be in range [0..10].".

The input for a pizza consists of several lines:
 On the first line is the pizza name and the number of toppings it has in the format:
o Pizza {pizzaName} {numberOfToppings}
 On the second line you will get input for the dough in format:
o Dough {flourType} {bakingTechnique} {weightInGrams}
 On the next lines, you will receive every topping the pizza has, until an&quot;END&quot; command is given:
o Topping {toppingType} {weightInGrams}
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] tokens = input.split("\\s+");

        try {
            String pizzaName = tokens[1];
            int toppingsCount = Integer.parseInt(tokens[2]);

            Pizza pizza = new Pizza(pizzaName, toppingsCount);

            tokens = scanner.nextLine().split("\\s+");

            String flourType = tokens[1];
            String bakingTechnique = tokens[2];
            double weight = Double.parseDouble(tokens[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            input = scanner.nextLine();

            while (!input.equals("END")) {
                tokens = input.split("\\s+");

                String toppingType = tokens[1];
                double weightInGrams = Double.parseDouble(tokens[2]);

                Topping topping = new Topping(toppingType, weightInGrams);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }
            System.out.println(pizza);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

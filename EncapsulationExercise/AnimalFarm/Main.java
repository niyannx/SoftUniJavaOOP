package EncapsulationExercise.AnimalFarm;

/*
---------------------------------------
| + Chicken(String, int)              |
| - setName(String) : void            |
| - setAge (int): void                |
| + productPerDay (): double          |
| + toString(): Override              |
| - calculateProductPerDay() : double |
---------------------------------------

You should be familiar with encapsulation already. For this problem,
you’ll need to create a class called Chicken. Chicken should contain
several fields, a constructor, and several methods. Your task is to
encapsulate or hide anything that is not intended to be viewed or
modified from outside the class.

Chicken lives for 15 years. Chicken has a name for sure, at least 1 symbol long. Chicken producing eggs:
 First 6 years it produces 2 eggs per day [0 - 5].
 Next 6 years it produces 1 egg per day [6 - 11].
 And after that, it produces 0.75 eggs per day.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Chicken chicken = null;

        try {
            chicken = new Chicken(name, age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (chicken != null) {
            System.out.println(chicken);
        }
    }
}

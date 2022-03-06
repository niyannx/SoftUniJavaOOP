package EncapsulationLab.ValidationData;

/*
Expand Person with proper validation for every field:
 Names must be at least 3 symbols
 Age must not be zero or negative
 Salary can't be less than 460.0
Print proper message to end-user (look at an example for messages).
Don't use System.out.println() in Person class.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            try {
                String firstName = input[0];
                String lastName = input[1];
                int age = Integer.parseInt(input[2]);
                double salary = Double.parseDouble(input[3]);

                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.parseDouble(reader.readLine());

        for (Person person : people) {
            person.increaseSalary(bonus);

            System.out.println(person.toString());
        }
    }
}

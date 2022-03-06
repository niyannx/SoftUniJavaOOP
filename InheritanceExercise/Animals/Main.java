package InheritanceExercise.Animals;

/*
Create a hierarchy (package) of animals. Your program should have three different animals – Dog, Frog, and Cat.
Deeper in the hierarchy you should have two additional classes – Kitten and Tomcat. Kittens are "Female" and
Tomcats are "Male". All types of animals should be able to produce some kind of sound - String
produceSound(). For example, the dog should be able to bark. Your task is to model the hierarchy and test its
functionality. Create an animal of each kind and make them all produce sound and create getters for all fields.
You will be given some lines of input. Every two lines will represent an animal. On the first line will be the type of
animal and on the second – the name, the age, and the gender. When the command "Beast!" is given, stop the
input and print all the animals in the format shown below.

Print the information for each animal on three lines. On the first line, print: "{animalType}"
 On the second line, print: "{name} {age} {gender}"
 On the third line, print the sounds it produces: "{produceSound()}"

Each Animal should have a name, an age, and a gender.
 All input values should not be blank (e.g. name, age, and so on…).
 If you receive an input for the gender of a Tomcat or a Kitten, ignore it but create the animal.
 If the input is invalid for one of the properties, throw an exception with the message: &quot;Invalid input!&quot;.
 Each animal should have the functionality to produceSound().
 Here is the type of sound each animal should produce:
    o Dog: "Woof!";
    o Cat: "Meow meow";
    o Frog: "Ribbit";
    o Kittens: "Meow";
    o Tomcat: "MEOW";
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        while (!type.equals("Beast!")) {
            String[] data = scanner.nextLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            try {
                switch (type) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;

                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;

                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;

                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;

                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;

                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            type = scanner.nextLine();
        }
    }
}

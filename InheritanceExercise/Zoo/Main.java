package InheritanceExercise.Zoo;

/*
Follow the diagram and create all the classes. Each of them, except the Animal class, should inherit from
another class. The Animal class should have field name – String and Getter for a name.
Every class should have:
 A public constructor, which accepts one parameter: name
 */

public class Main {
    public static void main(String[] args) {
        Bear bear = new Bear("Pooh");

        System.out.println(bear.getName());
    }
}

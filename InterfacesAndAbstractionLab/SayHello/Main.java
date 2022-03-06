package InterfacesAndAbstractionLab.SayHello;

/*
Build hierarchy from classes and interfaces for this UML diagram

 ---------------------
|     <<Person>>      |
|---------------------|
| +getName(): String  |
| +sayHello(): String |
 ---------------------
           |
           \/
       Bulgarian
  + Bulgarian(name)
  + sayHello(): String

       European
  + European(name)
  + sayHello(): String

       Chinese
  + Chinese(name)
  + sayHello(): String
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}

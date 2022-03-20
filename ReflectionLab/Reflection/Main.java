package ReflectionLab.Reflection;

/*
Import "Reflection.java" to your "src" folder in your project. Try to use reflection and print some information
about this class. Print everything on a new line:
     This class type
     Super class type
     All interfaces that are implemented by this class
     Instantiate object using reflection and print it too.
Don’t change anything in "Reflection class"!
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // get the class information
        Class<Reflection> cl = Reflection.class;
        // get all interfaces a class implements
        Class[] interfacesOfCl = cl.getInterfaces();
        // get class constructor
        Constructor<Reflection> clConstructor = cl.getDeclaredConstructor();
        // initialize object:
        Reflection reflection = clConstructor.newInstance();

        // print class type + name of class:
        System.out.println(cl);
        // print type of parent class + name of parent class
        System.out.println(cl.getSuperclass());
        // print all interfaces:
        Arrays.stream(interfacesOfCl).forEach(System.out::println);
        // print initialized object:
        System.out.println(reflection);
    }
}

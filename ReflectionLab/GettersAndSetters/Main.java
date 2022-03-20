package ReflectionLab.GettersAndSetters;

/*
Using reflection to get all Reflection methods. Then prepare an algorithm that will recognize, which methods are
getters and setters. Sort each collection alphabetically by methods names. Print to console each getter on a new
line in the format:
 "{name} will return class {Return Type}"
Then print all setters in the format:
 "{name} and will set field of class {Parameter Type}"
Do this without changing anything in "Reflection.java"
 */

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Reflection.class.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s\n",
                        method.getName(), method.getReturnType().getName()));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s\n",
                        method.getName(), method.getParameterTypes()[0].getName()));
    }
}

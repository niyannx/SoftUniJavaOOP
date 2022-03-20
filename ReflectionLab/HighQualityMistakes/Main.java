package ReflectionLab.HighQualityMistakes;

/*
You are already an expert on High-Quality Code, so you know what kind of access modifiers must be set to
members of the class. Time for revenge has come. Now you have to check the code produced by your "Beautiful
and Smart" trainers in class Reflection. Check all fields and methods access modifiers. Sort each category of
members alphabetically. Print on the console all mistakes in the format:

     For Fields:
"{fieldName} must be private!"

     For Getters:
"{methodName} have to be public!"

     For Setters:
"{methodName} have to be private!"
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class cl = Reflection.class;

        Field[] fields = Arrays.stream(cl.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        Method[] getters = Arrays.stream(cl.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

        Method[] setters = Arrays.stream(cl.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

        for (Field field : fields) {
            int modifiers = field.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.printf("%s must be private!\n", field.getName());
            }
        }

        for (Method method : getters) {
            int modifiers = method.getModifiers();

            if (!Modifier.isPublic(modifiers)) {
                System.out.printf("%s have to be public!\n", method.getName());
            }
        }

        for (Method method : setters) {
            int modifiers = method.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.printf("%s have to be private!\n", method.getName());
            }
        }
    }
}

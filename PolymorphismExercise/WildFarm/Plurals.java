package PolymorphismExercise.WildFarm;

import java.util.HashMap;
import java.util.Map;

public class Plurals {
    public static final Map<String, String> pluralOfAnimals = new HashMap<>();

    static {
        pluralOfAnimals.put("Mouse", "Mice");
        pluralOfAnimals.put("Zebra", "Zebras");
        pluralOfAnimals.put("Cat", "Cats");
        pluralOfAnimals.put("Tiger", "Tigers");
    }
}

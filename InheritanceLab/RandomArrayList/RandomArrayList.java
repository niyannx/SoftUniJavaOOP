package InheritanceLab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public RandomArrayList() {
    }

    public T getRandomElement() {
        Random random = new Random();

        return super.get(random.nextInt(super.size()));
    }
}

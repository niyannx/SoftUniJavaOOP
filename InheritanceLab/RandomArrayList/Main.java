package InheritanceLab.RandomArrayList;

/*
Create a RandomArrayList class that has all the functionality of an ArrayList.
Add a function that returns and removes a random element from the list.
 Public method: getRandomElement(): Object
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        RandomArrayList<String> randomArrayList = new RandomArrayList<String>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            randomArrayList.add(input);

            input = scan.nextLine();
        }

        System.out.println(randomArrayList);

        System.out.println(randomArrayList.getRandomElement());
    }
}

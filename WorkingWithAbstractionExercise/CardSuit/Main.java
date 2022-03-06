package WorkingWithAbstractionExercise.CardSuit;

/*
Create an enumeration type that has as its constants the four suits of a deck of playing cards
(CLUBS, DIAMONDS, HEARTS, SPADES). Iterate over the values of the enumeration type and print all ordinal values and names.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");

        Arrays.stream(CardSuits.values())
                .forEach(value ->
                        System.out.printf("Ordinal value: %d; Name value: %s%n",
                                value.ordinal(), value.name()));
    }
}

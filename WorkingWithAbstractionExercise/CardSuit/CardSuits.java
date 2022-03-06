package WorkingWithAbstractionExercise.CardSuit;

public enum CardSuits {
    CLUBS(0, "CLUBS"),
    DIAMONDS(1, "DIAMONDS"),
    HEARTS(2, "HEARTS"),
    SPADES(3, "SPADES");

    private int ordinalValue;
    private String name;

    CardSuits(int ordinalValue, String name) {
        this.ordinalValue = ordinalValue;
        this.name = name;
    }
}

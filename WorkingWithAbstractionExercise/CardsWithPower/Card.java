package WorkingWithAbstractionExercise.CardsWithPower;

public class Card {
    private int power;
    private String suit;
    private String rank;

    public Card(int rankPower, int suitPower, String suit, String rank) {
        this.power = rankPower + suitPower;
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank, suit, power);
    }
}

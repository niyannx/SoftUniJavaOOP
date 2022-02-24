package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrice(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        double price;

        price = pricePerDay * numberOfDays;
        price = price * season.getMultiplier();
        price = price * (100 - discountType.getDiscount()) / 100;

        return price;
    }
}

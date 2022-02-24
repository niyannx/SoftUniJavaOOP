package WorkingWithAbstractionLab.HotelReservation;

/*
Create a class PriceCalculator that calculates the total price of a holiday, given the price per day, number of days, the season and a discount type. The discount type and season should be enums.
Use the class in your main() method to read input and print on the console the price of the whole holiday.

The price per day will be multiplied depending on the season by:
•	1 during Autumn
•	2 during Spring
•	3 during Winter
•	4 during Summer

The discount is applied to the total price and is one of the following:
•	20% for VIP clients - VIP
•	10% for clients, visiting for a second time - SecondVisit
•	0% if there is no discount - None

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season currSeason = Season.valueOf(input[2]);
        DiscountType discountType = DiscountType.valueOf(input[3]);

        double price = PriceCalculator.calculateFinalPrice(pricePerDay, numberOfDays, currSeason, discountType);

        System.out.printf("%.2f\n", price);
    }
}

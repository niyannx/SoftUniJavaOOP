package SOLIDLab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public class Special extends OrderItem {
    public double getItemPrice() {
        double total = 0 ;

        total += this.getQuantity() * 4.0;
        int setsOfThree = this.getQuantity() / 3;
        total -= setsOfThree * 2.0;

        return total;
    }
}

package SOLIDLab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public abstract class Each extends OrderItem {
    public double getItemPrice() {
        return this.getQuantity() * 5.0;
    }
}

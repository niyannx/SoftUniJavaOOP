package SOLIDLab.p02_OpenClosedPrinciple.p03_ShoppingCart.OrderItems;

public abstract class OrderItem {
    private String barcode;
    private int quantity;

    public abstract double getItemPrice();

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

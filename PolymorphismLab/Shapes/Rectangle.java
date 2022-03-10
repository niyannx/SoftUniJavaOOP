package PolymorphismLab.Shapes;

public class Rectangle extends Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    void calculatePerimeter() {
        super.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    void calculateArea() {
        super.setArea(this.height * this.width);
    }

    public final double getHeight() {
        return height;
    }

    public final double getWidth() {
        return width;
    }
}

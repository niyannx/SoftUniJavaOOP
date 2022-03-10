package PolymorphismLab.Shapes;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    void calculateArea() {
        super.setArea(Math.PI * Math.pow(this.radius, 2));
    }

    public final double getRadius() {
        return this.radius;
    }
}

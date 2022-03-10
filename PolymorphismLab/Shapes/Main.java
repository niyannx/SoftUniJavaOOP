package PolymorphismLab.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(3, 4);
        Shape circle = new Circle(45);

        System.out.println(rect.getArea());
        System.out.println(rect.getPerimeter());

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}

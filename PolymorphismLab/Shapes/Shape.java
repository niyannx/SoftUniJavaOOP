package PolymorphismLab.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    abstract void calculatePerimeter();
    abstract void calculateArea();

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        if (perimeter == null) {
            calculatePerimeter();
        }

        return perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
        return area;
    }
}

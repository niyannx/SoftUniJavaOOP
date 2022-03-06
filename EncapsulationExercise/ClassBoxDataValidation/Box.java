package EncapsulationExercise.ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException(message("Length"));
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException(message("Width"));
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException(message("Height"));
        }
        this.height = height;
    }

    private String message (String side) {
        return String.format("%s cannot be zero or negative.", side);
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}

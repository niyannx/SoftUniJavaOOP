package PolymorphismExercise.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    // ------- FIELDS
    private double fuelQuantity;
    private double fuelConsumption;
    private int tankCapacity;

    // ------- CONSTRUCTOR
    public VehicleImpl(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    // ------- GETTERS & SETTERS
    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    // ------- OVERRIDE METHODS
    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;

        // if there is enough fuel
        if (fuelNeeded > this.fuelQuantity) {
            // travel is unsuccessful
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        // travel is successful
        this.fuelQuantity = this.fuelQuantity - fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.getFuelQuantity() + liters > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity = this.fuelQuantity + liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}

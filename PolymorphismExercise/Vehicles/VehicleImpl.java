package PolymorphismExercise.Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    // ------- FIELDS
    private double fuelQuantity;
    private double fuelConsumption;

    // ------- CONSTRUCTOR
    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
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

    // ------- OVERRIDE METHODS
    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.getFuelConsumption();

        // if there is enough fuel
        if (fuelNeeded > fuelQuantity) {
            // travel is unsuccessful
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        // travel is successful
        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}

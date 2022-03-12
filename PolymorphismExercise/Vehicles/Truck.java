package PolymorphismExercise.Vehicles;

public class Truck extends VehicleImpl {
    // ------- CONSTANT SUMMER INCREASE
    private static double SUMMER_INCREASE = 1.6;
    private static final double REFUEL_DECREASE_PERCENTAGE = 0.95;

    // ------- CONSTRUCTOR
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    // OVERRIDE VEHICLEIMPL METHODS
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + SUMMER_INCREASE);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_DECREASE_PERCENTAGE);
    }
}

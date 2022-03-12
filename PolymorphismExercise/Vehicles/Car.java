package PolymorphismExercise.Vehicles;

public class Car extends VehicleImpl {
    // ------- CONSTANT FIELDS
    private static double SUMMER_INCREASE = 0.9;

    // ------- CONSTRUCTOR
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    // OVERRIDE VEHICLEIMPL METHODS
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + SUMMER_INCREASE);
    }
}

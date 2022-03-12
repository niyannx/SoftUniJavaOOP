package PolymorphismExercise.VehiclesExtension;

public class Truck extends VehicleImpl {
    // ------- CONSTANT SUMMER INCREASE
    private static final double AC_INCREASE = 1.6;
    private static final double REFUEL_DECREASE_PERCENTAGE = 0.95;

    // ------- CONSTRUCTOR
    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    // OVERRIDE VEHICLEIMPL METHODS
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_INCREASE);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * REFUEL_DECREASE_PERCENTAGE);
    }
}

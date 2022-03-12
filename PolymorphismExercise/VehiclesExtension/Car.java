package PolymorphismExercise.VehiclesExtension;

public class Car extends VehicleImpl {
    // ------- CONSTANT FIELDS
    private static final double AC_INCREASE = 0.9;

    // ------- CONSTRUCTOR
    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    // OVERRIDE VEHICLEIMPL METHODS
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_INCREASE);
    }
}

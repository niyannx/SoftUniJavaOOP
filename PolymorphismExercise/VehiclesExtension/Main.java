package PolymorphismExercise.VehiclesExtension;

/*
Use your solution of the previous task for a starting point and add more functionality. Add new vehicle – Bus. Now
every vehicle has tank capacity and fuel quantity cannot fall (set) below 0 (If fuel quantity becomes less than 0 print
on the console "Fuel must be a positive number").

The vehicles cannot be filled with fuel more than their tank capacity. If you try to put more fuel in the tank than
the available space, print on the console &quot;Cannot fit fuel in tank&quot; and do not add any fuel in the vehicle&#39;s
tank.

Add new command for the bus. The bus can drive with or without people. If the bus is driving with people, the air-
conditioner is turned on and its fuel consumption per kilometer is increased by 1.4 liters. If there are no people in
the bus when driving the air-conditioner is turned off and does not increase the fuel consumption.

Input
 On the first three lines you will receive information about the vehicles in the format:
    Vehicle {initial fuel quantity} {liters per km} {tank capacity}
 On the fourth line - a number of commands N that will be given on the next N lines.
 On the next N lines – commands in format:
    o Drive Car {distance}
    o Drive Truck {distance}
    o Drive Bus {distance}
    o DriveEmpty Bus {distance}
    o Refuel Car {liters}
    o Refuel Truck {liters}
    o Refuel Bus {liters}
*/

import java.util.Scanner;

public class Main {
    private static Vehicle car;
    private static Vehicle truck;
    private static Vehicle bus;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // read vehicle info
        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");
        String[] busInfo = scan.nextLine().split("\\s+");

        // create objects
        car = readInfo(carInfo);
        truck = readInfo(truckInfo);
        bus = readInfo(busInfo);

        // loop through all commands
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] commands = scan.nextLine().split("\\s+");

            String command = commands[0]; // = drive, driveEmpty or refuel
            String vehicle = commands[1]; // = car, truck or bus
            double distanceOrLiters = Double.parseDouble(commands[2]);

            try {
                switch (command) {
                    case "Drive":
                        drive(vehicle, distanceOrLiters);
                        break;

                    case "Refuel":
                        refuel(vehicle, distanceOrLiters);
                        break;

                    case "DriveEmpty":
                        driveEmptyBus(distanceOrLiters);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        printOutput();
    }

    private static void printOutput() {
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void driveEmptyBus(double distance) {
        // if there are no passengers on the bus
        if (bus instanceof Bus) {
            ((Bus) bus).setEmpty(true);
        }

        System.out.println(bus.drive(distance));
    }

    private static void drive(String vehicle, double distance) {
        if (vehicle.equals("Car")) {
            System.out.println(car.drive(distance));
        } else if (vehicle.equals("Truck")) {
            System.out.println(truck.drive(distance));
        } else {
            if (bus instanceof Bus) {
                ((Bus) bus).setEmpty(false);
            }

            System.out.println(bus.drive(distance));
        }
    }

    private static void refuel(String vehicle, double liters) {
        if (vehicle.equals("Car")) {
            car.refuel(liters);
        } else if (vehicle.equals("Truck")) {
            truck.refuel(liters);
        } else {
            bus.refuel(liters);
        }
    }

    private static Vehicle readInfo(String[] info) {
        String type = info[0];
        double fuelQuantity = Double.parseDouble(info[1]);
        double fuelConsumption = Double.parseDouble(info[2]);
        int tankCapacity = Integer.parseInt(info[3]);

        if (type.equals("Car")) {
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        } else if (type.equals("Truck")) {
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        } else {
            return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
    }
}

package PolymorphismExercise.Vehicles;

/*
Write a program that models 2 vehicles (Car and Truck) and will be able to simulate driving and refueling them in
the summer. Car and truck both have fuel quantity, fuel consumption in liters per km and can be driven given
distance and refueled with given liters. But in the summer both vehicles use the air conditioner and their fuel
consumption per km is increased by 0.9 liters for the car and with 1.6 liters for the truck. Also, the truck has a tiny
hole in its tank and when it gets refueled it gets only 95% of the given fuel. The car has no problems when refueling
and adds all given fuel to its tank. If the vehicle cannot travel a given distance its fuel does not change.

Input
 On the first line - information about the car in format "Car {fuel quantity} {liters per km}".
 On the second line – info about the truck in the format "Truck {fuel quantity} {liters per km}".
 On the third line - a number of commands N will be given on the next N lines.
 On the next N lines – commands in the format:
    o Drive Car {distance}
    o Drive Truck {distance}
    o Refuel Car {liters}
    o Refuel Truck {liters}
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");

        Vehicle car = readInfo(carInfo);
        Vehicle truck = readInfo(truckInfo);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] commands = scan.nextLine().split("\\s+");

            if (commands[0].equals("Drive")) {
                double distance = Double.parseDouble(commands[2]);
                if (commands[1].equals("Car")) {
                    System.out.println(car.drive(distance));
                } else {
                    System.out.println(truck.drive(distance));
                }
            } else {
                double liters = Double.parseDouble(commands[2]);
                if (commands[1].equals("Car")) {
                    car.refuel(liters);
                } else {
                    truck.refuel(liters);
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }

    private static Vehicle readInfo(String[] info) {
        String type = info[0];
        double fuelQuantity = Double.parseDouble(info[1]);
        double fuelConsumptionPerKilometer = Double.parseDouble(info[2]);

        if (type.equals("Car")) {
            return new Car(fuelQuantity, fuelConsumptionPerKilometer);
        } else {
            return new Truck(fuelQuantity, fuelConsumptionPerKilometer);
        }
    }
}

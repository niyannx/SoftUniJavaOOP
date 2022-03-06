package InterfacesAndAbstractionLab.Ferrari;

/*
Model an application that contains a class Ferrari and an interface. Your task is simple, you have a car - Ferrari, its
model is &quot;488-Spider&quot; and it has a driver. Your Ferrari should have the functionality to use brakes and push the
gas pedal. When the brakes are pushed down print "Brakes!", and when the gas pedal is pushed down - "brum-
brum-brum-brrrrr". As you may have guessed this functionality is typical for all cars, so you should implement an
interface to describe it.

Your task is to create a Ferrari and set the driver&#39;s name to the passed one in the input. After that, print the info.
Take a look at the Examples to understand the task better.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String driverName = scan.nextLine();

        Ferrari ferrari = new Ferrari(driverName);

        System.out.printf("%s/%s/%s/%s\n",
                ferrari.getModel(),
                ferrari.brakes(),
                ferrari.gas(),
                ferrari.getDriverName());
    }
}

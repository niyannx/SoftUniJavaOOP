package EncapsulationExercise.ClassBoxDataValidation;

/*
You are given a geometric figure Box with fields length, width, and height. Model a class Box that can be
instantiated by the same three parameters. Expose to the outside world only methods for its surface area, lateral
surface area, and its volume (formulas: http://www.mathwords.com/r/rectangular_parallelepiped.htm).
On the first three lines, you will get the length, width, and height. On the next three lines print the surface area,
lateral surface area, and the volume of the box.
A box’s side should not be zero or a negative number. Add data validation for each parameter given to the
constructor. Make a private setter that performs data validation internally.

------------------------------------------------------
|                        Box                         |
|----------------------------------------------------|
|- length: double                                    |
|- width: double                                     |
|- height: double                                    |
|----------------------------------------------------|
|+ Box (double length, double width, double height)  |
|- setLength(double): void                           |
|- setWidth(double): void                            |
|- setHeight(double): void                           |
|+ calculateSurfaceArea (): double                   |
|+ calculateLateralSurfaceArea (): double            |
|+ calculateVolume (): double                        |
------------------------------------------------------
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = null;

        try {
            box = new Box(length, width, height);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (box != null) {
            System.out.printf("Surface Area - %.2f\n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f\n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f\n", box.calculateVolume());
        }
    }
}

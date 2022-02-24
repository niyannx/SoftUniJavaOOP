package WorkingWithAbstractionLab.PointInRectangle;

/*
Create a class Point and a class Rectangle. The Point should hold coordinates X and Y and the Rectangle should hold
2 Points – its bottom left and top right corners. In the Rectangle class, you should implement a contains(Point pt)
method that returns true or false, based on whether the Point given as attribute is inside or outside the Rectangle
object. Points on the side of a Square are considered inside.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] parameters = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = parameters[0];
        int bottomLeftY = parameters[1];
        int topRightX = parameters[2];
        int topRightY = parameters[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointInfo = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int pointX = pointInfo[0];
            int pointY = pointInfo[1];

            Point point = new Point(pointX, pointY);

            System.out.println(rectangle.contains(point));
        }
    }
}

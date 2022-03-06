package WorkingWithAbstractionExercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] colors = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < colors.length; j++) {
                colors[j] = Colors.valueOf(colors[j]).getName();

                System.out.print(colors[j] + " ");
            }
            System.out.println();
        }
    }
}

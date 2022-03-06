package WorkingWithAbstractionExercise.JediGalaxy;

/*
His galaxy is represented as a two-dimensional array. Every cell in the matrix is a star that has a value. Peter starts at
the given col and row. He can move only on the diagonal from the lowest left to the upper right and adds to his
score all the stars (values) from the cells he passes through. Unfortunately, there is always an Evil power that tries
to prevent his success.
Evil power starts at the given row and col and instantly destroys all-stars on the opposite diagonal – From the
lowest right to the upper left.
Peter adds the values only of the stars that are not destroyed by the evil power.
You will receive two integers, separated by space, which represent the two-dimensional array - the first being the
rows and the second being the columns. Then, you must fill the two-dimensional array with increasing integers
starting from 0, and continuing on every row, like this:
first row: 0, 1, 2… m
second row: n+1, n+2, n+3… n + n.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // fields
    public static int xE;
    public static int yE;

    public static int xI;
    public static int yI;

    public static int[][] matrix;

    public static long sum;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        createMatrix(scan);

        sum = 0;

        String command = scan.nextLine();
        // while the program's not to be terminated
        while (!command.equals("Let the Force be with you")) {
            findIvoAndEvilCoordinates(command, scan);

            evilRemovesCells();

            sum = findCollectedByIvo(sum);

            command = scan.nextLine();
        }

        System.out.println(sum);
    }

    public static void fillMatrix() {
        // value of current cell
        int value = 0;

        // the cell values increase by 1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    public static void createMatrix(Scanner scan) {
        // reads the dimensions of matrix
        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // x = rows, y = cols
        int x = dimensions[0];
        int y = dimensions[1];

        matrix = new int[x][y];

        fillMatrix();
    }

    public static void findIvoAndEvilCoordinates(String command, Scanner scan) {
        // command is Ivo and evil coordinates
        int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] evil = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // xE = row evil, yE = col evil
        xE = evil[0];
        yE = evil[1];

        // xI = row Ivo, yI = colIvo
        xI = ivoS[0];
        yI = ivoS[1];
    }

    public static void evilRemovesCells() {
        // while evil is inside the matrix
        while (xE >= 0 && yE >= 0) {
            if (xE < matrix.length && yE < matrix[0].length) {
                // make the value of evil's cell = 0
                matrix[xE][yE] = 0;
            }

            // move evil diagonally
            xE--;
            yE--;
        }
    }

    public static long findCollectedByIvo(long sum) {
        while (xI >= 0 && yI < matrix[1].length) {
            if (xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                sum += matrix[xI][yI];
            }

            yI++;
            xI--;
        }

        return sum;
    }
}

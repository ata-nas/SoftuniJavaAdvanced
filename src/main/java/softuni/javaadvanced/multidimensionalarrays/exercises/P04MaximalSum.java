package softuni.javaadvanced.multidimensionalarrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] curRow = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = curRow;
        }

        int highestMaxRowStart = -1;
        int highestMaxColStart = -1;
        int highestSum = Integer.MIN_VALUE;
        for (int row = 0; row + 2 < matrix.length; row++) {
            for (int col = 0; col + 2 < matrix[0].length; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row][col + 2]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1]
                        + matrix[row + 1][col + 2]
                        + matrix[row + 2][col]
                        + matrix[row + 2][col + 1]
                        + matrix[row + 2][col + 2];
                if (sum > highestSum) {
                    highestSum = sum;
                    highestMaxRowStart = row;
                    highestMaxColStart = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", highestSum);
        System.out.printf("%d %d %d%n",
                matrix[highestMaxRowStart][highestMaxColStart],
                matrix[highestMaxRowStart][highestMaxColStart + 1],
                matrix[highestMaxRowStart][highestMaxColStart + 2]);
        System.out.printf("%d %d %d%n",
                matrix[highestMaxRowStart + 1][highestMaxColStart],
                matrix[highestMaxRowStart + 1][highestMaxColStart + 1],
                matrix[highestMaxRowStart + 1][highestMaxColStart + 2]);
        System.out.printf("%d %d %d%n",
                matrix[highestMaxRowStart + 2][highestMaxColStart],
                matrix[highestMaxRowStart + 2][highestMaxColStart + 1],
                matrix[highestMaxRowStart + 2][highestMaxColStart + 2]);
    }
}

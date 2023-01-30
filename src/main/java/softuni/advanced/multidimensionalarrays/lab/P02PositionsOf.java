package softuni.advanced.multidimensionalarrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        int target = Integer.parseInt(sc.nextLine());

        printLocationsOfTarget(target, matrix);
    }

    public static void printLocationsOfTarget(int target, int[][] field) {
        boolean isFound = false;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                if (field[row][col] == target) {
                    System.out.printf("%d %d%n", row, col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}

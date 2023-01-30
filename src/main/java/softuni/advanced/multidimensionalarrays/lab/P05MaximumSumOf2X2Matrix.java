package softuni.advanced.multidimensionalarrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        int highestValueMatrixRow = -1;
        int highestValueMatrixCol = -1;
        int highestValueMatrixSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];

                if (sum > highestValueMatrixSum) {
                    highestValueMatrixSum = sum;
                    highestValueMatrixRow = row;
                    highestValueMatrixCol = col;
                }
            }
        }
        System.out.print(matrix[highestValueMatrixRow][highestValueMatrixCol] + " ");
        System.out.println(matrix[highestValueMatrixRow][highestValueMatrixCol + 1]);
        System.out.print(matrix[highestValueMatrixRow + 1][highestValueMatrixCol] + " ");
        System.out.println(matrix[highestValueMatrixRow + 1][highestValueMatrixCol + 1]);
        System.out.println(highestValueMatrixSum);
    }
}

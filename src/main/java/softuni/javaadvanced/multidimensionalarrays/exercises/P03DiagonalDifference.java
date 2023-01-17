package softuni.javaadvanced.multidimensionalarrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentRow;
        }

        int result = absDiagonalDif(matrix);
        System.out.println(result);
    }

    public static int absDiagonalDif(int[][] matrix) {
        int sumFirstDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumFirstDiagonal += matrix[i][i];
        }

        int sumSecondDiagonal = 0;
        for (int i = matrix.length - 1, j = 0; i >= 0; i--, j++) {
            sumSecondDiagonal += matrix[i][j];
        }

        return Math.abs(sumFirstDiagonal - sumSecondDiagonal);
    }
}

package softuni.javaadvanced.multidimensionalarrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRow;
        }

        printSquareMatrixDiagonals(matrix);
    }

    public static void printSquareMatrixDiagonals(int[][] matrix) {
        String firstDiagonal = "";
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i] + " ";
        }

        System.out.println(firstDiagonal.trim());

        String secondDiagonal = "";
        for (int i = matrix.length - 1, j = 0; j < matrix.length; i--, j++) {
            secondDiagonal += matrix[i][j] + " ";
        }

        System.out.println(secondDiagonal.trim());
    }
}

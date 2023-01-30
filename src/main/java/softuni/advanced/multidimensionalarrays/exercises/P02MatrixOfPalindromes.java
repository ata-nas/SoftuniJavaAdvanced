package softuni.advanced.multidimensionalarrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String wrapper = (char)(97 + row) + "";
                String middle = (char)((97 + row) + col) + "";
                matrix[row][col] = wrapper + middle + wrapper;
            }
        }

        for (String[] row : matrix) {
            System.out.println(String.join(" ", row).trim());
        }
    }
}

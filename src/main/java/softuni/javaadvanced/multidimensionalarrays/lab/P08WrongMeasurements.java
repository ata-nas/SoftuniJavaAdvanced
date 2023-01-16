package softuni.javaadvanced.multidimensionalarrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matrixRows = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[matrixRows][];

        for (int row = 0; row < matrixRows; row++) {
            int[] curRow = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = curRow;
        }

        int[] wrongValueLocation = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongValue = matrix[wrongValueLocation[0]][wrongValueLocation[1]];

        int[][] resultMatrix = new int[matrixRows][];
        for (int row = 0; row < matrixRows; row++) {
            resultMatrix[row] = matrix[row].clone();
        }


        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    resultMatrix[row][col] = sumAllDirections(matrix, row, col, wrongValue);
                }
            }
        }

        for (int row = 0; row < matrixRows; row++) {
            String curLine = "";
            for (int col = 0; col < matrix[0].length; col++) {
                curLine += resultMatrix[row][col] + " ";
            }
            System.out.println(curLine.trim());
        }
    }

    public static int sumAllDirections(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;

        // North
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }

        // South
        if (row + 1 <= matrix.length - 1 && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }

        // East
        if (col + 1 <= matrix[row].length - 1 && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }

        // West
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }

        return sum;
    }
}

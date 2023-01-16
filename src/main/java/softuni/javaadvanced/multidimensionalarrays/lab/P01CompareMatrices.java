package softuni.javaadvanced.multidimensionalarrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstMatrixRowsAndCols = sc.nextLine().split("\\s+");
        int firstMatrixRows = Integer.parseInt(firstMatrixRowsAndCols[0]);
        int firstMatrixCols = Integer.parseInt(firstMatrixRowsAndCols[1]);

        int[][] matrixA = new int[firstMatrixRows][firstMatrixCols];

        for (int row = 0; row < firstMatrixRows; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < firstMatrixCols; col++) {
                matrixA[row][col] = currentRow[col];
            }
//            System.arraycopy(currentRow, 0, matrix[row], 0, cols);
        }

        String[] secondMatrixRowsAndCols = sc.nextLine().split("\\s+");
        int secondMatrixRows = Integer.parseInt(secondMatrixRowsAndCols[0]);
        int secondMatrixCols = Integer.parseInt(secondMatrixRowsAndCols[1]);

        int[][] matrixB = new int[secondMatrixRows][secondMatrixCols];

        for (int row = 0; row < secondMatrixRows; row++) {
            int[] currentRow = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < secondMatrixCols; col++) {
                matrixB[row][col] = currentRow[col];
            }
//            System.arraycopy(currentRow, 0, matrix[row], 0, cols);
        }

        boolean areEqual = equalMatrices(matrixA, matrixB);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    public static boolean equalMatrices(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length) {
            return false;
        }

        for (int row = 0; row < matrixA.length; row++) {
            if (matrixA[row].length != matrixB[row].length) {
                return false;
            }
            for (int col = 0; col < matrixA[0].length; col++) {
                if (matrixA[row][col] != matrixB[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
//    public static int[][] generateMatrix(int rows, int cols) {
//        Scanner sc = new Scanner(System.in);
//
//        int[][] matrix = new int[rows][cols];
//
//        for (int row = 0; row < rows; row++) {
//            int[] currentRow = Arrays.stream(sc.nextLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            for (int col = 0; col < cols; col++) {
//                matrix[row][col] = currentRow[col];
//            }
////            System.arraycopy(currentRow, 0, matrix[row], 0, cols);
//        }
//        return matrix;
//    }
//}

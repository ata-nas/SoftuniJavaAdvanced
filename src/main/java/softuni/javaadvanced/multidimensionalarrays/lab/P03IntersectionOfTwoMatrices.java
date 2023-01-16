package softuni.javaadvanced.multidimensionalarrays.lab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] matrixA = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = String.join("", sc.nextLine().split("\\s+")).toCharArray();
            matrixA[row] = currentRow;
        }

        char[][] matrixB = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] currentRow = String.join("", sc.nextLine().split("\\s+")).toCharArray();
            matrixB[row] = currentRow;
        }
        matrixIntersectionPrinter(matrixA, matrixB);
    }

    public static void matrixIntersectionPrinter(char[][] matrixA, char[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixB[0].length;

        for (int row = 0; row < rows; row++) {
            String resultRow = "";
            for (int col = 0; col < cols; col++) {
                if (matrixA[row][col] == matrixB[row][col]) {
                    resultRow += matrixA[row][col] + " ";
                } else {
                    resultRow += "* ";
                }
            }
            System.out.println(resultRow.trim());
        }
    }
}

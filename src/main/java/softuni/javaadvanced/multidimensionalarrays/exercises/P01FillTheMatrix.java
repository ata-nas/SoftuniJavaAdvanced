package softuni.javaadvanced.multidimensionalarrays.exercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizeAndType = sc.nextLine().split(", ");

        int size = Integer.parseInt(sizeAndType[0]);

        char type = sizeAndType[1].charAt(0);

        if (type == 'A') {
            typeA(size);
        } else if (type == 'B') {
            typeB(size);
        }

    }

    public static void typeA(int size) {
        int[][] matrix = new int[size][size];

        int currentNumber = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = currentNumber;
                currentNumber++;
            }
        }

        printMatrix(matrix);
    }

    public static void typeB(int size) {
        int[][] matrix = new int[size][size];

        int currentNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
        }

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String currentRow = "";
            for (int col = 0; col < matrix[0].length; col++) {
                currentRow += matrix[row][col] + " ";
            }
            System.out.println(currentRow.trim());
        }
    }
}

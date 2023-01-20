package softuni.javaadvanced.multidimensionalarrays.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {

    private final static String COMMAND_END = "END";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int degreeRotation = Integer.parseInt(sc.nextLine().replaceAll("\\D", "")) % 360;

        List<String> matrixRowConstructor = new ArrayList<>();

        int maxLenMatrixRow = Integer.MIN_VALUE;

        while (true) {
            String command = sc.nextLine();

            if (command.equals(COMMAND_END)) {
                break;
            }

            if (command.length() > maxLenMatrixRow) {
                maxLenMatrixRow = command.length();
            }

            matrixRowConstructor.add(command);
        }

        int rows = matrixRowConstructor.size();
        int cols = maxLenMatrixRow;

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] curRow = matrixRowConstructor.get(row).split("");

            for (int col = 0; col < cols; col++) {
                if (col > curRow.length - 1) {
                    matrix[row][col] = " ";
                    continue;
                }

                matrix[row][col] = curRow[col];
            }
        }

        printMatrixRotation(degreeRotation, matrix);
    }

    private static void printMatrixRotation(int degrees, String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        switch (degrees) {
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            default:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
        }
    }
}

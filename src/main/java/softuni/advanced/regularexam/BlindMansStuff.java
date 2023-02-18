package softuni.advanced.regularexam;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansStuff {

    private static final Scanner sc = new Scanner(System.in);
    private static int movesMade = 0;
    private static int playersTouched = 0;

    public static void main(String[] args) {

        String[][] matrix = createMatrix();

        while (true) {
            String command = sc.nextLine();

            if (command.equals("Finish") || playersTouched >= 3) {
                break;
            }

            switch (command) {
                case "up":
                    moveUp(matrix);
                    break;
                case "down":
                    moveDown(matrix);
                    break;
                case "left":
                    moveLeft(matrix);
                    break;
                case "right":
                    moveRight(matrix);
                    break;
            }
        }

        System.out.println("Game over!");
        System.out.print("Touched opponents: " + playersTouched + " ");
        System.out.println("Moves made: " + movesMade);

    }

    private static void moveRight(String[][] matrix) {
        int[] coordinates = getCurrentCoordinates(matrix);
        int r = coordinates[0];
        int c = coordinates[1];

        if (c + 1 >= matrix[0].length || matrix[r][c+1].equals("O")) {
            return;
        }

        if (matrix[r][c+1].equals("P")) {
            matrix[r][c] = "-";
            matrix[r][c+1] = "B";
            playersTouched += 1;
        }

        if (matrix[r][c+1].equals("-")) {
            matrix[r][c] = "-";
            matrix[r][c+1] = "B";
        }

        movesMade += 1;
    }

    private static void moveLeft(String[][] matrix) {
        int[] coordinates = getCurrentCoordinates(matrix);
        int r = coordinates[0];
        int c = coordinates[1];

        if (c - 1 < 0 || matrix[r][c-1].equals("O")) {
            return;
        }

        if (matrix[r][c-1].equals("P")) {
            matrix[r][c] = "-";
            matrix[r][c-1] = "B";
            playersTouched += 1;
        }

        if (matrix[r][c-1].equals("-")) {
            matrix[r][c] = "-";
            matrix[r][c-1] = "B";
        }

        movesMade += 1;
    }

    private static void moveDown(String[][] matrix) {
        int[] coordinates = getCurrentCoordinates(matrix);
        int r = coordinates[0];
        int c = coordinates[1];

        if (r + 1 >= matrix.length || matrix[r+1][c].equals("O")) {
            return;
        }

        if (matrix[r+1][c].equals("P")) {
            matrix[r][c] = "-";
            matrix[r+1][c] = "B";
            playersTouched += 1;
        }

        if (matrix[r+1][c].equals("-")) {
            matrix[r][c] = "-";
            matrix[r+1][c] = "B";
        }

        movesMade += 1;

    }

    private static void moveUp(String[][] matrix) {
        int[] coordinates = getCurrentCoordinates(matrix);
        int r = coordinates[0];
        int c = coordinates[1];

        if (r - 1 < 0 || matrix[r-1][c].equals("O")) {
            return;
        }

        if (matrix[r-1][c].equals("P")) {
            matrix[r][c] = "-";
            matrix[r-1][c] = "B";
            playersTouched += 1;
        }

        if (matrix[r-1][c].equals("-")) {
            matrix[r][c] = "-";
            matrix[r-1][c] = "B";
        }

        movesMade += 1;
    }

    private static int[] getCurrentCoordinates(String[][] matrix) {
        int[] coordinates = new int[2];

        boolean found = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals("B")){
                    coordinates[0] = row;
                    coordinates[1] = col;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return coordinates;
    }

    private static String[][] createMatrix() {
        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] currRow = sc.nextLine().split("\\s+");
            matrix[i] = currRow;
        }

        return matrix;
    }

}

package softuni.javaadvanced.multidimensionalarrays.exercises;

import java.util.*;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] curRow = sc.nextLine().split("\\s+");
            matrix[row] = curRow;
        }

        while (true) {
            String command = sc.nextLine();
            if (command.equals("END")) {
                break;
            }

            if (!validCommand(command, rows, cols)) {
                System.out.println("Invalid input!");
                continue;
            }

            String[] commandArr = command.split("\\s+");

            int fRow = Integer.parseInt(commandArr[1]);
            int fCol = Integer.parseInt(commandArr[2]);
            int sRow = Integer.parseInt(commandArr[3]);
            int sCol = Integer.parseInt(commandArr[4]);

            String firstValue = matrix[fRow][fCol];
            String secondValue = matrix[sRow][sCol];

            matrix[fRow][fCol] = secondValue;
            matrix[sRow][sCol] = firstValue;

            for (int row = 0; row < rows; row++) {
                System.out.println(String.join(" ", matrix[row]));
            }
        }
    }

    private static boolean validCommand(String command, int rows, int cols) {
        String[] commandArr = command.split("\\s+");

        if (commandArr.length != 5) {
            return false;
        }

        if (!commandArr[0].equals("swap")){
            return false;
        }

        try {
            int fRow = Integer.parseInt(commandArr[1]);
            int fCol = Integer.parseInt(commandArr[2]);
            int sRow = Integer.parseInt(commandArr[3]);
            int sCol = Integer.parseInt(commandArr[4]);

            if (fRow < 0
            || fRow >= rows
            || fCol < 0
            || fCol >= cols
            || sRow < 0
            || sRow >= rows
            || sCol < 0
            || sCol >= cols) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

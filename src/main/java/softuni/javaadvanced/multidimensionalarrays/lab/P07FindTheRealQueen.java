package softuni.javaadvanced.multidimensionalarrays.lab;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matrixSize = 8;

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrixSize; row++) {
            char[] currentRow = String.join("", sc.nextLine().split("\\s+")).toCharArray();
            matrix[row] = currentRow;
        }

        int realQueenRow = -1;
        int realQueenCol = -1;
        boolean queenFound = false;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col] == 'q') {
                    queenFound = validateQueen(matrix, row, col);
                    if(queenFound) {
                        realQueenRow = row;
                        realQueenCol = col;
                        break;
                    }

                }
            }
            if (queenFound) {
                break;
            }
        }
        String result = realQueenRow + " " + realQueenCol;
        System.out.println(result);
    }

    public static boolean validateQueen(char[][] matrix, int row, int col) {
        // check North
        for (int curRow = row - 1; curRow >= 0; curRow--) {
            if (matrix[curRow][col] == 'q') {
                return false;
            }
        }

        // check South
        for (int curRow = row + 1; curRow <= 7; curRow++) {
            if (matrix[curRow][col] == 'q') {
                return false;
            }
        }

        // check East
        for (int curCol = col + 1; curCol <= 7; curCol++) {
            if (matrix[row][curCol] == 'q') {
                return false;
            }
        }

        // check West
        for (int curCol = col - 1; curCol >= 0; curCol--) {
            if (matrix[row][curCol] == 'q') {
                return false;
            }
        }

        // check diagonal right to left q to top
        for (int curRow = row - 1, curCol = col - 1; curRow >= 0 && curCol >= 0; curRow--, curCol--) {
            if (matrix[curRow][curCol] == 'q') {
                return false;
            }
        }

        // check diagonal left to right q to bottom
        for (int curRow = row + 1, curCol = col + 1; curRow <= 7 && curCol <= 7; curRow++, curCol++) {
            if (matrix[curRow][curCol] == 'q') {
                return false;
            }
        }

        // check diagonal right to left q to bottom
        for (int curRow = row + 1, curCol = col - 1; curRow <= 7 && curCol >= 0; curRow++, curCol--) {
            if (matrix[curRow][curCol] == 'q') {
                return false;
            }
        }

        for (int curRow = row - 1, curCol = col + 1; curRow >= 0 && curCol <= 7; curRow--, curCol++) {
            if (matrix[curRow][curCol] == 'q') {
                return false;
            }
        }
        return true;
    }
}

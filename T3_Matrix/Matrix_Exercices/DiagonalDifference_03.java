package MatrixExercices;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            matrix[row] = input;
        }

        int sumFirstDiagonal = fillFirstDiagonalMatrix(matrix,scanner);
        int sumSecondDiagonal = fillSecondDiagonalMatrix(matrix,scanner);

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }

    private static int fillSecondDiagonalMatrix(int[][] matrix, Scanner scanner) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1){
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int fillFirstDiagonalMatrix(int[][] matrix, Scanner scanner) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col){
                    sum += matrix[row][col];
                }
            }
        }
        return  sum;
    }
}

package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowMatrix = Integer.parseInt(scanner.nextLine());
        int colMatrix = 0;

        int[][] matrix = new int[rowMatrix][];

        for (int row = 0; row < rowMatrix; row++) {
            int[] input = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            colMatrix = input.length;
            matrix[row] = input;
        }

        int[] wrongInput = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int wrongRow = wrongInput[0];
        int wrongCol = wrongInput[1];
        int wrongElement = matrix[wrongRow][wrongCol];

        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                int sum = 0;
                if (matrix[row][col] == wrongElement){
                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongElement){
                        sum += matrix[row][col - 1];
                    }
                    if (col + 1 < colMatrix && matrix[row][col + 1] != wrongElement){
                        sum += matrix[row][col + 1];
                    }
                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongElement){
                        sum += matrix[row - 1][col];
                    }
                    if (row + 1 < rowMatrix && matrix[row + 1][col] != wrongElement){
                        sum += matrix[row + 1][col];
                    }
                    matrix[row][col] = sum;
                }
            }
        }

        printMatrix(matrix,colMatrix);
    }

    private static void printMatrix(int[][] matrix, int colMatrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < colMatrix; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

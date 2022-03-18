package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonal_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndCol = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowAndCol][rowAndCol];

        for (int i = 0; i < matrix.length; i++) {
            int[] data = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            matrix[i] = data;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col){
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1){
                    System.out.print(matrix[col][row] + " ");
                }
            }
        }
    }
}

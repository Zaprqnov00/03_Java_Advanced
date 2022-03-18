package MatrixExercices;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rowColMatrix = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[rowColMatrix][rowColMatrix];

        if (pattern.equals("A")){
            int count = 1;
            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }else {
            int count = 1;
            for (int col = 0; col < matrix.length; col++) {
                if (col % 2 == 0){
                    for (int row = 0; row < matrix.length; row++) {
                        matrix[row][col] = count;
                        count++;
                    }
                }else {
                    for (int row = matrix.length - 1; row >= 0 ; row--) {
                        matrix[row][col] = count;
                        count++;
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

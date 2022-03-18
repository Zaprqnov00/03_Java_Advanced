package MatrixExercices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int rowMatrix = input[0];
        int colMatrix = input[1];

        String[][] matrix = new String[rowMatrix][colMatrix];

        char letter = 'a';
        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                matrix[row][col] =  "" + letter + (char)(letter + col) + letter;
            }
            letter++;
        }

        printMatrix(matrix,colMatrix);
    }

    private static void printMatrix(String[][] matrix,int colMatrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < colMatrix; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

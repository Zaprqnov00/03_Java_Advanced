package MatrixExercices;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int rowMatrix = inputNumbers[0];
        int colMatrix = inputNumbers[1];

        String[][] matrix = new String[rowMatrix][colMatrix];

        fillMatrix(matrix,rowMatrix,colMatrix,scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] input = command.split("\\s+");

            if (!input[0].equals("swap") || !(input.length == 5)){
                System.out.println("Invalid input!");
            }else {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);

                if (row1 < 0 || row1 > rowMatrix || row2 < 0 || row2 > rowMatrix ||
                col1 < 0 || col1 > colMatrix || col2 < 0 || col2 > colMatrix){
                    System.out.println("Invalid input!");
                }else {
                    String numberFirst = matrix[row1][col1];
                    String numberSecond = matrix[row2][col2];

                    matrix[row1][col1] = numberSecond;
                    matrix[row2][col2] = numberFirst;

                    printReadyMatrix(matrix, rowMatrix, colMatrix);
                }
            }

            command = scanner.nextLine();
        }


    }

    private static void printReadyMatrix(String[][] matrix, int rowMatrix, int colMatrix) {

        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, int rowMatrix, int colMatrix, Scanner scanner) {

        for (int row = 0; row < rowMatrix; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < colMatrix; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}

package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = inputNumbers[0];
        int col = inputNumbers[1];

        int[][] matrix = new int[row][col];

        fillMatrix(matrix,scanner,row,col);
        int searchNumber = Integer.parseInt(scanner.nextLine());

        boolean numberInMatrix = false;
        for (int rowMatrix = 0; rowMatrix < row; rowMatrix++) {
            for (int colMatrix = 0; colMatrix < col; colMatrix++) {
                if (matrix[rowMatrix][colMatrix] == searchNumber){
                    System.out.println(rowMatrix + " " + colMatrix);
                    numberInMatrix = true;
                }
            }
        }

        if (!numberInMatrix){
            System.out.println("not found");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner,int rows,int cols) {

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }
}

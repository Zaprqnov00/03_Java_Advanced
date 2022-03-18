package MatrixLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumMatrixElement_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNumbers = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int rowMatrix = inputNumbers.get(0);
        int colMatrix = inputNumbers.get(1);

        int[][] matrix = new int[rowMatrix][colMatrix];

        fillMatrix(matrix,scanner,rowMatrix,colMatrix);

        int sum = sumMatrix(matrix,rowMatrix,colMatrix);

        System.out.printf("%d\n%d\n%d\n",rowMatrix,colMatrix,sum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner,int rowMatrix, int colMatrix) {

        for (int row = 0; row < rowMatrix; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < colMatrix; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }

    private static int sumMatrix(int[][] matrix, int rowMatrix, int colMatrix){
        int sum = 0;
        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                int currentNum = matrix[row][col];
                sum += currentNum;
            }
        }
        return sum;
    }
}

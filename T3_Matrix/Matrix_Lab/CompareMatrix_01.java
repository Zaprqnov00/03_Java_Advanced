package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int firstRowMatrix = firstInput[0];
        int firstColMatrix = firstInput[1];

        int[][]firstMatrix = new int[firstRowMatrix][firstColMatrix];

        for (int row = 0; row < firstRowMatrix; row++) {
            int[] sumByMatrix = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            for (int col = 0; col < firstColMatrix; col++) {
                firstMatrix[row][col] = sumByMatrix[col];
            }
        }

        int[] secondInput = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondRowMatrix = secondInput[0];
        int secondColMatrix = secondInput[1];

        int[][]secondMatrix = new int[secondRowMatrix][secondColMatrix];

        for (int row = 0; row < secondRowMatrix; row++) {
            int[] sumByMatrix = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < secondColMatrix; col++) {
                secondMatrix[row][col] = sumByMatrix[col];
            }
        }

        if (firstColMatrix != secondColMatrix || firstRowMatrix != secondRowMatrix){
            System.out.println("not equal");
            return;
        }

        boolean equalMatrix = isMatrix(firstRowMatrix, firstColMatrix, firstMatrix, secondMatrix);

        if (equalMatrix){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    private static boolean isMatrix(int firstRowMatrix, int firstColMatrix, int[][] firstMatrix, int[][] secondMatrix) {
        boolean equalMatrix = false;
        for (int row = 0; row < firstRowMatrix; row++) {
            for (int col = 0; col < firstColMatrix; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    equalMatrix = true;
                }else {
                    equalMatrix = false;
                    break;
                }
            }
        }
        return equalMatrix;
    }
}

package MatrixLab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowMatrix = Integer.parseInt(scanner.nextLine());
        int colMatrix = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rowMatrix][colMatrix];
        char[][] secondMatrix = new char[rowMatrix][colMatrix];

        fillMatrixs(scanner, rowMatrix, colMatrix, firstMatrix);

        fillMatrixs(scanner, rowMatrix, colMatrix, secondMatrix);

        checkElementMatrix(rowMatrix, colMatrix, firstMatrix, secondMatrix);
    }

    private static void checkElementMatrix(int rowMatrix, int colMatrix, char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    System.out.print(firstMatrix[row][col] + " ");
                }else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }

    private static void fillMatrixs(Scanner scanner, int rowMatrix, int colMatrix, char[][] firstMatrix) {
        for (int row = 0; row < rowMatrix; row++) {
            String[] input = scanner.nextLine().split(" ");// a b c d
            for (int col = 0; col < colMatrix; col++) {
                char symbols = input[col].charAt(0);
                firstMatrix[row][col] = symbols;
            }
        }
    }
}

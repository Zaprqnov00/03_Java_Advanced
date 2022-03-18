package Exam_19_02_2022;

import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                if (input[col].equals("w")){
                    wRow = row;
                    wCol = col;
                }
                if (input[col].equals("b")){
                    bRow = row;
                    bCol = col;
                }
                matrix[row][col] = input[col];
            }
        }


    }
}

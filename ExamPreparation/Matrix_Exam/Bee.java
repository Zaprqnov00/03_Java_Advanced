package Matrix_Exam;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int flowers = 0;

        fillMatrix(scanner, n, matrix);

        String command = scanner.nextLine();
        while (!command.equals("End")){

            int beeRow = 0;
            int beeCol = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (matrix[row][col] == 'B'){
                        beeRow = row;
                        beeCol = col;
                    }
                }
            }

            matrix[beeRow][beeCol] = '.';
            switch (command){
                case "right":
                    beeCol++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
            }
            if (beeCol >= n || beeCol < 0 || beeRow >= n || beeRow < 0){
                System.out.println("The bee got lost!");
                break;
            }
            if (matrix[beeRow][beeCol] == 'f'){
                flowers++;
            }else if (matrix[beeRow][beeCol] == 'O'){
                matrix[beeRow][beeCol] = '.';
                switch (command){
                    case "right":
                        beeCol++;
                        break;
                    case "left":
                        beeCol--;
                        break;
                    case "up":
                        beeRow--;
                        break;
                    case "down":
                        beeRow++;
                        break;
                }
                if (beeCol >= n || beeCol < 0 || beeRow >= n || beeRow < 0){
                    System.out.println("The bee got lost!");
                    break;
                }
                if (matrix[beeRow][beeCol] == 'f'){
                    flowers++;
                }
            }

            matrix[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }

        if (flowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n",flowers);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n",5 - flowers);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                matrix[row][col] = symbol;
            }
        }
    }
}

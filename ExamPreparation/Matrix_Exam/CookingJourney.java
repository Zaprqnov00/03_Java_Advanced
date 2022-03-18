package Matrix_Exam;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int myRow = 0;
        int myCol = 0;
        int pillarRow = 0;
        int pillarCol = 0;
        int money = 0;

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                matrix[row][col] = symbol;
                if (symbol == 'S'){
                    myCol = col;
                    myRow = row;
                }
                if (symbol == 'P'){
                    pillarRow = row;
                    pillarCol = col;
                }
            }
        }

        while (money < 50){
            String move = scanner.nextLine();

            matrix[myRow][myCol] = '-';
            switch (move){
                case "right":
                    myCol++;
                    break;
                case "left":
                    myCol--;
                    break;
                case "up":
                    myRow--;
                    break;
                case "down":
                    myRow++;
                    break;
            }
            if (myRow >= n || myRow < 0 || myCol >= n || myCol < 0){
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            char symbol = matrix[myRow][myCol];
            if (symbol == 'P'){
                matrix[myRow][myCol] = '-';
                myRow = pillarRow;
                myCol = pillarCol;
            }else if (Character.isDigit(symbol)){
                money += Integer.parseInt(String.valueOf(symbol));
            }

            matrix[myRow][myCol] = 'S';
        }
        if (money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

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
}

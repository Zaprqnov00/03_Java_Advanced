package Matrix_Exam;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nMatrix = Integer.parseInt(scanner.nextLine());
        int nCommand = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[nMatrix][nMatrix];
        int playerRow = 0;
        int playerCol = 0;
        boolean reachesF = false;

        for (int row = 0; row < nMatrix; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 'P'){
                    playerRow = row;
                    playerCol = col;
                }
                matrix[row][col] = symbol;
            }
        }

        for (int i = 0; i < nCommand; i++) {
            String move = scanner.nextLine();

            matrix[playerRow][playerCol] = '.';
            switch (move){
                case "right":
                    playerCol++;
                    if (playerCol >= nMatrix){
                        playerCol = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0){
                        playerCol = matrix.length - 1;
                    }
                    break;
                case "up":
                    playerRow--;
                    if (playerRow < 0){
                        playerRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= nMatrix){
                        playerRow = 0;
                    }
                    break;
            }
            if (matrix[playerRow][playerCol] == 'F'){
                matrix[playerRow][playerCol] = 'P';
                reachesF = true;
                break;
            } else if (matrix[playerRow][playerCol] == 'B') {
                switch (move) {
                    case "right":
                        playerCol++;
                        if (playerCol >= nMatrix) {
                            playerCol = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = matrix.length - 1;
                        }
                        break;
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = matrix.length - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow >= nMatrix) {
                            playerRow = 0;
                        }
                        break;
                }
                if (matrix[playerRow][playerCol] == 'F'){
                    matrix[playerRow][playerCol] = 'P';
                    reachesF = true;
                    break;
                }
            }
            if (matrix[playerRow][playerCol] == 'T'){
                if (move.equals("right")){
                    playerCol--;
                }else if (move.equals("left")){
                    playerCol++;
                }else if (move.equals("up")){
                    playerRow++;
                }else if (move.equals("down")){
                    playerRow--;
                }
            }

            matrix[playerRow][playerCol] = 'P';
        }

        if (reachesF){
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
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
}

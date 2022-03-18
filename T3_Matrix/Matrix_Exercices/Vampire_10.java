package MatrixExercices;

import java.util.Arrays;
import java.util.Scanner;

public class Vampire_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumber = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int rowMatrix = inputNumber[0];
        int colMatrix = inputNumber[1];
        int playerRow = 0;
        int playerCol = 0;

        String[][] matrix = new String[rowMatrix][colMatrix];

        for (int row = 0; row < rowMatrix; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < colMatrix; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("P")){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String[] commands = scanner.nextLine().split("");

        boolean playerWin = false;
        for (int i = 0; i < commands.length; i++) {
            String move = commands[i];

            moveBunnies(matrix,rowMatrix,colMatrix,playerWin);
            matrix[playerRow][playerCol] = ".";
            if (move.equals("L")){
                playerCol--;
                if (playerCol < 0){
                    playerWin =  true;
                    playerCol++;
                    break;
                }
            }else if (move.equals("R")){
                playerCol++;
                if (playerCol > colMatrix){
                    playerWin = true;
                    playerCol--;
                    break;
                }
            }else if (move.equals("U")){
                playerRow--;
                if (playerRow < 0){
                    playerWin = true;
                    playerRow++;
                    break;
                }
            }else if (move.equals("D")){
                playerRow++;
                if (playerRow > rowMatrix){
                    playerWin = true;
                    playerRow--;
                    break;
                }
            }
            if (matrix[playerRow][playerCol].equals("B")){
                playerWin = false;
                break;
            }

            matrix[playerRow][playerCol] = "P";
        }

        printMatrix(matrix,rowMatrix,colMatrix);
        if (playerWin){
            System.out.printf("won: %d %d\n",playerRow,playerCol);
        }else {
            System.out.printf("dead: %d %d\n",playerRow,playerCol);
        }
    }

    private static void printMatrix(String[][] matrix, int rowMatrix, int colMatrix) {

        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


    private static void moveBunnies(String[][] matrix, int rowMatrix, int colMatrix, boolean playerWin) {

        for (int row = 0; row < rowMatrix; row++) {
            for (int col = 0; col < colMatrix; col++) {
                if (matrix[row][col].equals("B")){
                    if (row + 1 <= rowMatrix){
                        if (matrix[row + 1][col].equals("P")){
                            playerWin = false;
                            matrix[row + 1][col] = "B";
                            break;
                        }
                        matrix[row + 1][col] = "B";
                    }
                    if (col - 1 >= 0){
                        if (matrix[row][col - 1].equals("P")){
                            playerWin = false;
                            matrix[row][col - 1] = "B";
                            break;
                        }
                        matrix[row][col - 1] = "B";
                    }
                    if (row - 1 >= 0){
                        if (matrix[row - 1][col].equals("P")){
                            playerWin = false;
                            matrix[row - 1][col] = "B";
                            break;
                        }
                        matrix[row - 1][col] = "B";
                    }
                    if (col + 1 < colMatrix){
                        if (matrix[row][col + 1].equals("P")){
                            playerWin = false;
                            matrix[row][col + 1] = "B";
                            break;
                        }
                        matrix[row][col + 1] = "B";
                    }
                    return;
                }
            }
        }
    }
}

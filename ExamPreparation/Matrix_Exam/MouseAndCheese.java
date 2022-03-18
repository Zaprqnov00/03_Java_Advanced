package Matrix_Exam;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int rowMouse = 0;
        int colMouse = 0;
        int countCheese = 0;

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 'M'){
                    rowMouse = row;
                    colMouse = col;
                }
                matrix[row][col] = symbol;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")){

            matrix[rowMouse][colMouse] = '-';
            if (command.equals("right")){
                colMouse++;
            }else if (command.equals("left")){
                colMouse--;
            }else if (command.equals("up")){
                rowMouse--;
            }else if (command.equals("down")){
                rowMouse++;
            }
            if (colMouse < 0 || colMouse >= n || rowMouse < 0 || rowMouse >= n){
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[rowMouse][colMouse] == 'c'){
                countCheese++;
            }else if (matrix[rowMouse][colMouse] == 'B'){
                matrix[rowMouse][colMouse] = '-';
                if (command.equals("right")){
                    colMouse++;
                }else if (command.equals("left")){
                    colMouse--;
                }else if (command.equals("up")){
                    rowMouse--;
                }else if (command.equals("down")){
                    rowMouse++;
                }
                if (colMouse < 0 || colMouse >= n || rowMouse < 0 || rowMouse >= n){
                    System.out.println("Where is the mouse?");
                    break;
                }
                if (matrix[rowMouse][colMouse] == 'c') {
                    countCheese++;
                }
            }

            matrix[rowMouse][colMouse] = 'M';

            command = scanner.nextLine();
        }

        if (countCheese < 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n",5 - countCheese);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n",countCheese);
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

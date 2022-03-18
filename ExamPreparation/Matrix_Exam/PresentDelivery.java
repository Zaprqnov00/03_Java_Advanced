package Matrix_Exam;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mCountPresents = Integer.parseInt(scanner.nextLine());
        int nSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[nSize][nSize];
        int santaRow = 0;
        int santaCol = 0;

        int countNiceKid = 0;
        int presentForNaughtyKid = 0;
        int presentForNiceKid = 0;


        for (int row = 0; row < nSize; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                char symbol = input[col].charAt(0);
                if (symbol == 'S'){
                    santaRow = row;
                    santaCol = col;
                }
                if (symbol == 'V'){
                    countNiceKid++;
                }
                matrix[row][col] = symbol;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")){

            matrix[santaRow][santaCol] = '-';
            switch (command){
                case "right":
                    santaCol++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
            }
            if (matrix[santaRow][santaCol] == 'V'){
                countNiceKid--;
                presentForNiceKid++;
                mCountPresents--;
                matrix[santaRow][santaCol] = 'S';
            }else if (matrix[santaRow][santaCol] == 'C'){
                matrix[santaRow][santaCol] = 'S';
                if (matrix[santaRow + 1][santaCol] == 'V'){
                    mCountPresents--;
                    countNiceKid--;
                    presentForNiceKid++;
                    matrix[santaRow + 1][santaCol] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow - 1][santaCol] == 'V'){
                    mCountPresents--;
                    countNiceKid--;
                    presentForNiceKid++;
                    matrix[santaRow - 1][santaCol] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow][santaCol + 1] == 'V'){
                    mCountPresents--;
                    countNiceKid--;
                    presentForNiceKid++;
                    matrix[santaRow][santaCol + 1] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow][santaCol - 1] == 'V'){
                    mCountPresents--;
                    countNiceKid--;
                    presentForNiceKid++;
                    matrix[santaRow][santaCol - 1] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow + 1][santaCol] == 'X'){
                    presentForNaughtyKid++;
                    mCountPresents--;
                    matrix[santaRow + 1][santaCol] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow - 1][santaCol] == 'X'){
                    presentForNaughtyKid++;
                    mCountPresents--;
                    matrix[santaRow - 1][santaCol] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow][santaCol + 1] == 'X'){
                    presentForNaughtyKid++;
                    mCountPresents--;
                    matrix[santaRow][santaCol + 1] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
                if (matrix[santaRow][santaCol - 1] == 'X'){
                    presentForNaughtyKid++;
                    mCountPresents--;
                    matrix[santaRow][santaCol - 1] = '-';
                    if (mCountPresents == 0){
                        System.out.println("Santa ran out of presents!");
                        break;
                    }
                }
            } else {
                matrix[santaRow][santaCol] = 'S';
            }

            if (mCountPresents <= 0){
                System.out.println("Santa ran out of presents!");
                break;
            }
            command = scanner.nextLine();
        }

        printMatrix(matrix);

        if (countNiceKid == 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n",presentForNiceKid);
        }else if (countNiceKid > 0){
            System.out.printf("No presents for %d nice kid/s.\n",countNiceKid);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

package Matrix_Exam;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int parisRow = 0;
        int parisCol = 0;
        int helenRow = 0;
        int helenCol = 0;

        String[][] matrix = new String[n][n];
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("P")){
                    parisCol = col;
                    parisRow = row;
                }
                if (matrix[row][col].equals("H")){
                    helenRow = row;
                    helenCol = col;
                }
            }
        }
        String command = scanner.nextLine();
        while (true){
            String[] input = command.split("\\s+");
            String move = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);

            matrix[spartanRow][spartanCol] = "S";
            matrix[parisRow][parisCol] = "-";
            switch (move){
                case "right":
                    parisCol++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
            }
            if (parisCol < 0 || parisCol >= n || parisRow < 0 || parisRow >= n){
                energy--;
                if (move.equals("right")){
                    parisCol--;
                }else if (move.equals("left")){
                    parisCol++;
                }else if (move.equals("up")){
                    parisRow++;
                }else {
                    parisRow--;
                }
            }else {
                energy--;
            }
            if (matrix[parisRow][parisCol].equals("S")){
                energy -= 2;
            }else if (matrix[parisRow][parisCol].equals("H")){
                matrix[parisRow][parisCol] = "-";
                matrix[helenRow][helenCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n",energy);
                break;
            }
            if (energy <= 0){
                matrix[parisRow][parisCol] = "X";
                System.out.printf("Paris died at %d;%d.\n",parisRow,parisCol);
                break;
            }

            matrix[parisRow][parisCol] = "P";
            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

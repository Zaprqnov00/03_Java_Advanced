package MatrixLab;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix.length; col++) {
                char symbol = input[col].charAt(0);
                matrix[row][col] = symbol;
            }
        }


        for (int row = 0; row < matrix.length; row++) {
            int countQueen = 0;
            int rowQueen = 0;
            int colQueen = 0;
            for (int col = 0; col < matrix.length; col++) {
                if ( matrix[row][col] == 'q'){
                    countQueen++;
                    rowQueen = row;
                    colQueen = col;
                }
            }
            if (countQueen == 1){
                System.out.println(rowQueen + " " + colQueen);
                break;
            }
        }

    }
}

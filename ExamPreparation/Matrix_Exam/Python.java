package Matrix_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        int food = 0;

        int snakeRow = 0;
        int snakeCol = 0;

        int n = Integer.parseInt(scanner.nextLine());
        List<String> moveInput = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String[][] matrix = new String[n][n];

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("s")){
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col].equals("f")){
                    food++;
                }
            }
        }

        for (int i = 0; i < moveInput.size(); i++) {
            String move = moveInput.get(i);

            matrix[snakeRow][snakeCol] = "*";
            if (move.equals("right")){
                snakeCol++;
                if (snakeCol >= n){
                    snakeCol = 0;
                }
            }else if (move.equals("left")){
                snakeCol--;
                if (snakeCol < 0){
                    snakeCol = n - 1;
                }
            }else if (move.equals("up")){
                snakeRow--;
                if (snakeRow < 0){
                    snakeRow = n - 1;
                }
            }else if (move.equals("down")){
                snakeRow++;
                if (snakeRow >= n){
                    snakeRow = 0;
                }
            }
            if (matrix[snakeRow][snakeCol].equals("f")){
                pythonLength++;
                food--;
            }else if (matrix[snakeRow][snakeCol].equals("e")){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            matrix[snakeRow][snakeCol] = "s";

            if (food == 0){
                System.out.println("You win! Final python length is " + pythonLength);
                return;
            }
        }

        if (food > 0){
            System.out.printf("You lose! There is still %d food to be eaten.\n",food);
        }
    }
}

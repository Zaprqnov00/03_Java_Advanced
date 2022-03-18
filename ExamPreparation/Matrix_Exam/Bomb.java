package Matrix_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> moveCommands = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        String[][] matrix = new String[n][n];
        int sapperRow = 0;
        int sapperCol = 0;
        int bombs = 0;

        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col];
                if (matrix[row][col].equals("s")){
                    sapperRow = row;
                    sapperCol = col;
                }
                if (matrix[row][col].equals("B")){
                    bombs++;
                }
            }
        }

        for (int i = 0; i < moveCommands.size(); i++) {
            String move = moveCommands.get(i);

            matrix[sapperRow][sapperCol] = "+";
            switch (move){
                case "right":
                    sapperCol++;
                    if (sapperCol >= n){
                        sapperCol--;
                    }
                    break;
                case "left":
                    sapperCol--;
                    if (sapperCol < 0){
                        sapperCol++;
                    }
                    break;
                case "up":
                    sapperRow--;
                    if (sapperRow < 0){
                        sapperRow++;
                    }
                    break;
                case "down":
                    sapperRow++;
                    if (sapperRow >= n){
                        sapperRow--;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol].equals("e")){
                matrix[sapperRow][sapperCol] = "s";
                System.out.printf("END! %d bombs left on the field\n",bombs);
                return;
            }else if (matrix[sapperRow][sapperCol].equals("B")){
                matrix[sapperRow][sapperCol] = "+";
                System.out.println("You found a bomb!");
                bombs--;
            }else {
                matrix[sapperRow][sapperCol] = "s";
            }

            if (bombs == 0){
                System.out.println("Congratulations! You found all bombs!");
                return;
            }

        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n",bombs,sapperRow,sapperCol);
    }
}

package StackAndQueuesExercices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        ArrayDeque<String> inputHistory = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputNumbers = scanner.nextLine().split(" ");
            String commandNumber = inputNumbers[0];

            if (commandNumber.equals("1")){
                inputHistory.push(stringBuilder.toString());
                String textAppend = inputNumbers[1];
                stringBuilder.append(textAppend);
            }else if (commandNumber.equals("2")){
                inputHistory.push(stringBuilder.toString());
                int count = Integer.parseInt(inputNumbers[1]);
                stringBuilder.delete(stringBuilder.length() - count,stringBuilder.length());
            }else if (commandNumber.equals("3")){
                int index = Integer.parseInt(inputNumbers[1]);
                System.out.println(stringBuilder.charAt(index - 1));
            }else {
                stringBuilder = new StringBuilder(inputHistory.pop());
            }
        }
    }
}

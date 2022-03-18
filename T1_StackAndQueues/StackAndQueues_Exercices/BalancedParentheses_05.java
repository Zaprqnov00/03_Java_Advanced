package StackAndQueuesExercices;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        ArrayDeque<Character> openParentheses = new ArrayDeque<>();
        ArrayDeque<Character> closeParentheses = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char currentSymbol = parentheses.charAt(i);

            if (currentSymbol == '{' || currentSymbol == '[' || currentSymbol == '('){
                openParentheses.push(currentSymbol);
            }
            if (currentSymbol == '}' || currentSymbol == ']' || currentSymbol == ')'){
                closeParentheses.offer(currentSymbol);
            }
        }
        boolean searchIsEqual = false;
        while (!openParentheses.isEmpty() && !closeParentheses.isEmpty()) {

            if (openParentheses.size() != closeParentheses.size()) {
                searchIsEqual = false;
                break;
            }

            char open = openParentheses.pop();
            char closed = closeParentheses.poll();

            if (open == '{' && closed == '}') {
                searchIsEqual = true;
            } else if (open == '[' && closed == ']') {
                searchIsEqual = true;
            } else if (open == '(' && closed == ')') {
                searchIsEqual = true;
            } else {
                searchIsEqual = false;
                break;
            }
        }

        if (searchIsEqual){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

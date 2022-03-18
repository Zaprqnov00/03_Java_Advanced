package StackAndQueuesLab;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());


        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (String element:elements) {
            numbers.offer(element);
        }

        while (numbers.size() > 1){
            int firstNumber = Integer.parseInt(numbers.poll());
            String symbol = numbers.poll();
            int secondNumber = Integer.parseInt(numbers.poll());

            if (symbol.equals("+")){
                numbers.push(String.valueOf(firstNumber + secondNumber));
            }else {
                numbers.push(String.valueOf(firstNumber - secondNumber));
            }
        }

        System.out.println(numbers.peek());
    }
}

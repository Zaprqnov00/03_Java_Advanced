package StackAndQueuesExercices;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumberInStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            numbersStack.push(numbers[i]);
        }

        for (int num :numbersStack) {
            System.out.print(num + " ");
        }
    }
}

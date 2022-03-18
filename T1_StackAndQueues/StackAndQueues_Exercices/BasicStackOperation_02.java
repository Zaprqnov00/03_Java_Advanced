package StackAndQueuesExercices;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperation_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        List<Integer> numbersCommand = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int n = numbersCommand.get(0);
        int s = numbersCommand.get(1);
        int x = numbersCommand.get(2);

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            stackNumbers.push(num);
        }
        for (int i = 0; i < s; i++) {
            stackNumbers.pop();
        }

        if (stackNumbers.isEmpty()){
            System.out.println("0");
            return;
        }

            if(stackNumbers.contains(x)){
                System.out.println("true");
            }else {
                System.out.println(Collections.min(stackNumbers));
            }


    }
}

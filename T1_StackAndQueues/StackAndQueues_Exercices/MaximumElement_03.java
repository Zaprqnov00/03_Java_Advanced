package StackAndQueuesExercices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> collectionNumbers = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            if (numbers[0] == 1){
                int pushNumber = numbers[1];
                collectionNumbers.push(pushNumber);
            }else if (numbers[0] == 2){
                collectionNumbers.pop();
            }else{
                System.out.println(Collections.max(collectionNumbers));
            }
        }
    }
}

package StackAndQueuesExercices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> collectionNumbers = new ArrayDeque<>();

        int[] numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        for (int i = 0; i < n; i++) {
            int offerNumber = scanner.nextInt();
            collectionNumbers.offer(offerNumber);
        }
        for (int i = 0; i < s; i++) {
            collectionNumbers.poll();
        }

        if (collectionNumbers.contains(x)){
            System.out.println("true");
        }else {
            if (collectionNumbers.isEmpty()){
                System.out.println("0");
            }else {
                System.out.println(Collections.min(collectionNumbers));
            }
        }
    }
}

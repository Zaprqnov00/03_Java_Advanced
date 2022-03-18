package StackAndQueues_Exam;

import java.util.*;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputFirstBox = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] inputSecondBox = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        for (int i = 0; i < inputFirstBox.length; i++) {
            firstBoxQueue.offer(inputFirstBox[i]);
        }
        for (int i = 0; i < inputSecondBox.length; i++) {
            secondBoxStack.push(inputSecondBox[i]);
        }

        List<Integer> collectionItems = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int firstBoxNumber = firstBoxQueue.peek();
            int lastNumber = secondBoxStack.peek();
            int sum = firstBoxNumber + lastNumber;

            if (sum % 2 == 0){
                collectionItems.add(sum);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            }else {
                firstBoxQueue.offer(secondBoxStack.pop());
            }

        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }
        if (secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        int sum = 0;
        for (int number :collectionItems) {
            sum += number;
        }
        if (sum >= 90){
            System.out.printf("Wow, your prey was epic! Value: %d\n",sum);
        }else {
            System.out.println("Poor prey... Value: " + sum);
        }
    }
}

package StackAndQueues_Exam;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputLilies = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> inputRoses = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        int collectionWithFlowers = 0;

        for (int lilies :inputLilies) {
            liliesStack.push(lilies);
        }
        for (int roses :inputRoses) {
            rosesQueue.offer(roses);
        }

        int wreath = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()){
            int lilies = liliesStack.peek();
            int roses = rosesQueue.peek();
            int sum = lilies + roses;

            if (sum == 15){
                wreath++;
                liliesStack.pop();
                rosesQueue.poll();
            }else if (sum > 15){
                liliesStack.push(liliesStack.pop() - 2);
            }else {
                collectionWithFlowers += sum;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }

        while (collectionWithFlowers >= 15){
            wreath++;
            collectionWithFlowers -= 15;
        }

        if (wreath >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n",wreath);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n",5 - wreath);
        }
    }
}

package StackAndQueues_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tulipsInput = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> daffodilsInput = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        int countBouquets = 0;
        int flowerStore = 0;

        for (int i = 0; i < tulipsInput.size(); i++) {
            tulipsStack.push(tulipsInput.get(i));
        }
        for (int i = 0; i < daffodilsInput.size(); i++) {
            daffodilsQueue.offer(daffodilsInput.get(i));
        }

        while (!tulipsStack.isEmpty() && ! daffodilsQueue.isEmpty()){
                int tulips = tulipsStack.peek();
                int daffodils = daffodilsQueue.peek();
                int sum = tulips + daffodils;

                if (sum == 15){
                    countBouquets++;
                    tulipsStack.pop();
                    daffodilsQueue.poll();
                }else if (sum > 15){
                    tulipsStack.push(tulipsStack.pop() - 2);
                }else {
                    flowerStore += sum;
                    tulipsStack.pop();
                    daffodilsQueue.poll();
                }

        }

            while (flowerStore >= 15){
                flowerStore = flowerStore - 15;
                countBouquets++;
            }


        if (countBouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!\n",countBouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.\n",5 - countBouquets);
        }
    }
}

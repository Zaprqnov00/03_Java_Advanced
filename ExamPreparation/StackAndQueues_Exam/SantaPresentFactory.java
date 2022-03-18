package StackAndQueues_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materialsInput = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] inputMagicLevel = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int doll = 0; //150
        int woodenTrain = 0; // 250
        int bear = 0; // 300
        int bicycle = 0; //400

        ArrayDeque<Integer> stackMaterials = new ArrayDeque<>();
        ArrayDeque<Integer> queueMagicLevel = new ArrayDeque<>();

        for (int i = 0; i < materialsInput.length; i++) {
            stackMaterials.push(materialsInput[i]);
        }
        for (int i = 0; i < inputMagicLevel.length; i++) {
            queueMagicLevel.offer(inputMagicLevel[i]);
        }

        while (!stackMaterials.isEmpty() && ! queueMagicLevel.isEmpty()){
            int material = stackMaterials.peek();
            int magicLevel = queueMagicLevel.peek();
            int sum = material * magicLevel;

            if (material == 0 && magicLevel == 0){
                stackMaterials.pop();
                queueMagicLevel.poll();
                continue;
            }else if (material == 0){
                stackMaterials.pop();
                continue;
            }else if (magicLevel == 0){
                queueMagicLevel.poll();
                continue;
            }


            if (sum == 150){
                doll++;
                stackMaterials.pop();
                queueMagicLevel.poll();
            } else if (sum == 250) {
                woodenTrain++;
                stackMaterials.pop();
                queueMagicLevel.poll();
            }else if (sum == 300){
                bear++;
                stackMaterials.pop();
                queueMagicLevel.poll();
            } else if (sum == 400) {
                bicycle++;
                stackMaterials.pop();
                queueMagicLevel.poll();
            }
            if (sum < 0){
                stackMaterials.pop();
                queueMagicLevel.poll();
                stackMaterials.push(material + magicLevel);
            }else if (sum > 0 && sum != 150 && sum != 250 && sum != 300 && sum != 400){
                queueMagicLevel.poll();
                stackMaterials.push(stackMaterials.pop() + 15);
            }
        }

        if (doll >= 1 && woodenTrain >= 1 || bear >= 1 && bicycle >= 1){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }
        if (!stackMaterials.isEmpty()) {
            System.out.println("Materials left: " + stackMaterials.toString().replaceAll("[\\[\\]]",""));
        }
        if (!queueMagicLevel.isEmpty()) {
            System.out.println("Magic left: " + queueMagicLevel.toString().replaceAll("[\\[\\]]",""));
        }

        if (bicycle > 0){
            System.out.println("Bicycle: " + bicycle);
        }
        if (doll > 0) {
            System.out.println("Doll: " + doll);
        }
        if (bear > 0) {
            System.out.println("Teddy bear: " + bear);
        }
        if (woodenTrain > 0) {
            System.out.println("Wooden train: " + woodenTrain);
        }
    }
}

package StackAndQueues_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputMale = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] inputFemale = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();

        for (int i = 0; i < inputFemale.length; i++) {
            femalesQueue.offer(inputFemale[i]);
        }
        for (int i = 0; i < inputMale.length; i++) {
            maleStack.push(inputMale[i]);
        }
        int countMatches = 0;

        while (!femalesQueue.isEmpty() && !maleStack.isEmpty()){
            int female = femalesQueue.peek();
            int male = maleStack.peek();

            if (male <= 0){
                maleStack.pop();
                continue;
            }
            if (female <= 0){
                femalesQueue.poll();
                continue;
            }

            if (female % 25 == 0){
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0){
                maleStack.pop();
                maleStack.pop();
                continue;
            }
            if (female == male){
                countMatches++;
                femalesQueue.poll();
                maleStack.pop();
            }else {
                femalesQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }
        }
        System.out.println("Matches: " + countMatches);
        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: " + maleStack.toString().replaceAll("[\\[\\]]",""));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        }else {
            System.out.println("Females left: " + femalesQueue.toString().replaceAll("[\\[\\]]",""));
        }
    }
}

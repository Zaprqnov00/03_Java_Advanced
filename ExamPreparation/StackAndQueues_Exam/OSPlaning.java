package StackAndQueues_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasks = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> threads = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int killTask = Integer.parseInt(scanner.nextLine());



        while (!tasks.isEmpty() && ! threads.isEmpty()) {
            int firstThreads = threads.get(0);
            int lastTasks = tasks.get(tasks.size() - 1);

            if (lastTasks == killTask){
                System.out.printf("Thread with value %d killed task %d\n",firstThreads,killTask);
                break;
            }

            if (firstThreads >= lastTasks) {
                threads.remove(0);
                tasks.remove(tasks.size() - 1);
            } else {
                threads.remove(0);
            }
        }

        if (!threads.isEmpty()){
            System.out.println(threads.toString().replaceAll("[\\[\\],]",""));
        }
    }
}

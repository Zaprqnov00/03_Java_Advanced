package FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> peopleMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            peopleMap.put(name,age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        if (condition.equals("older")){
            if (format.equals("name age")){
                fillOlderNameAge(peopleMap, age);
            }else if (format.equals("name")){
                fillOlderName(peopleMap,age);
            }else {
                fillOlderAge(peopleMap,age);
            }
        }else {
            if (format.equals("name age")){
                fillYoungerNameAge(peopleMap,age);
            }else if (format.equals("name")){
                fillYoungerName(peopleMap,age);
            }else {
                fillYoungerAge(peopleMap,age);
            }
        }
    }

    private static void fillYoungerAge(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() <= age){
                System.out.printf("%d\n",entry.getValue());
            }
        }
    }

    private static void fillYoungerName(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() <= age){
                System.out.printf("%s\n",entry.getKey());
            }
        }
    }

    private static void fillYoungerNameAge(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() <= age){
                System.out.printf("%s - %d\n",entry.getKey(),entry.getValue());
            }
        }

    }

    private static void fillOlderAge(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() >= age){
                System.out.printf("%d\n",entry.getValue());
            }
        }
    }

    private static void fillOlderName(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() >= age){
                System.out.printf("%s\n",entry.getKey());
            }
        }
    }

    private static void fillOlderNameAge(Map<String, Integer> peopleMap, int age) {
        for (Map.Entry<String, Integer> entry : peopleMap.entrySet()) {
            if (entry.getValue() >= age){
                System.out.printf("%s - %d\n",entry.getKey(),entry.getValue());
            }
        }
    }
}

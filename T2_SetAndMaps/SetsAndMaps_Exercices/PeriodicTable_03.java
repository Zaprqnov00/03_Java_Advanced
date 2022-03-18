package SetsAndMapsExercices;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> setWithElement = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (String element :input) {
                setWithElement.add(element);
            }
        }
        System.out.print(setWithElement.toString().replaceAll("[\\[\\],]",""));
    }
}

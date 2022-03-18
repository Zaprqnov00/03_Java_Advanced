package SetsAndMapsExercices;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstNumbersLength = numberInput[0];
        int secondNumbersLength = numberInput[1];

        Set<Integer> setFirst = new LinkedHashSet<>();
        Set<Integer> setSecond = new LinkedHashSet<>();

        for (int i = 0; i < firstNumbersLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            setFirst.add(number);
        }

        for (int i = 0; i < secondNumbersLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            setSecond.add(number);
        }

        for (int number :setFirst) {
            if (setSecond.contains(number)){
                System.out.print(number + " ");
            }
        }
    }
}

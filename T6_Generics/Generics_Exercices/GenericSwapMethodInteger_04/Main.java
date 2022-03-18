package GenericsExercices.GenericSwapMethodInteger_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> boxInteger = new Box<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            boxInteger.add(number);
        }

        int[] swapInput = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int firstIndex = swapInput[0];
        int secondIndex = swapInput[1];

        boxInteger.swap(firstIndex,secondIndex);

        System.out.println(boxInteger);
    }
}

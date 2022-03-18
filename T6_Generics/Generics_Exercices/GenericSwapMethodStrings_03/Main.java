package GenericsExercices.GenericSwapMethodStrings_03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> stringBox = new Box<>();

        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            stringBox.add(element);
        }

        int[] indexes = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        stringBox.swap(firstIndex,secondIndex);

        System.out.println(stringBox);
    }
}

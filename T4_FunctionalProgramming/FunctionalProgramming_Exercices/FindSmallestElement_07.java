package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Function<List<Integer>,Integer> smallElement = entry -> entry.lastIndexOf(Collections.min(numbers));

        System.out.println(smallElement.apply(numbers));
    }
}

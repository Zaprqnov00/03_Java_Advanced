package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> evenSort = numbers.stream().sorted().filter(num -> num % 2 == 0).collect(Collectors.toList());
        evenSort.forEach(entry -> System.out.print(entry + " "));
        List<Integer> oddSort = numbers.stream().sorted().filter(num -> num % 2 != 0).collect(Collectors.toList());
        oddSort.forEach(entry -> System.out.print(entry + " "));
    }
}

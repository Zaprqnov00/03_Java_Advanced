package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumber_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers.toString().replaceAll("[\\[\\]]",""));
        Collections.sort(evenNumbers);
        System.out.println(evenNumbers.toString().replaceAll("[\\[\\]]",""));
    }
}

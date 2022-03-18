package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int divisibleNum = Integer.parseInt(scanner.nextLine());

        numbers = numbers.stream().filter(num -> num % divisibleNum != 0).collect(Collectors.toList());
        Collections.reverse(numbers);
        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }
}

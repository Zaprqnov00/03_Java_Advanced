package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());
        int sum = numbers.stream().mapToInt(entry -> Integer.parseInt(String.valueOf(entry))).sum();
        System.out.println("Sum = " + sum);
    }
}

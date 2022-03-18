package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddVat_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                        .stream(scanner.nextLine().split(", "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());

        numbers = numbers.stream().map(num -> num * 1.20).collect(Collectors.toList());
        System.out.println("Prices with Vat:");
        numbers.forEach(entry -> System.out.printf("%.2f\n",entry));
    }
}

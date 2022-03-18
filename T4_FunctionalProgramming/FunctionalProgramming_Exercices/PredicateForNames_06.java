package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        names = names.stream().filter(name -> name.length() <= number).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}

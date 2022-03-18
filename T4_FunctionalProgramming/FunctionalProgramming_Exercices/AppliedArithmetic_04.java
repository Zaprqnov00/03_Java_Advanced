package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")){

            switch (command){
                case "add":
                    numbers = numbers.stream().map(num -> num + 1).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(num -> num * 2).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(num -> num - 1).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(entry -> System.out.printf("%d ",entry));
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}

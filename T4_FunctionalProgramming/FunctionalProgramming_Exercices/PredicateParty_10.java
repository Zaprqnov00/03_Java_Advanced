package FunctionalProgrammingExercices;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Party!")){
            String[] input = command.split(" ");
            String criteria = input[0];
            String options = input[1];

            switch (criteria){
                case "Remove":
                    if (options.equals("StartsWith")){
                        String symbol = input[2];
                        people.removeAll(people.stream().filter(person -> person.startsWith(symbol)).collect(Collectors.toList()));
                    }else if (options.equals("EndsWith")){
                        String symbol = input[2];
                        people.removeAll(people.stream().filter(person -> person.endsWith(symbol)).collect(Collectors.toList()));
                    }else {
                        int length = Integer.parseInt(input[2]);
                        people.removeAll(people.stream().filter(person -> person.length() == length).collect(Collectors.toList()));
                    }
                    break;
                case "Double":
                    if (options.equals("StartsWith")){
                        String symbol = input[2];
                        people.addAll(people.stream().filter(name -> name.startsWith(symbol)).collect(Collectors.toList()));
                    }else if (options.equals("EndsWith")){
                        String symbol = input[2];
                        people.addAll(people.stream().filter(name -> name.endsWith(symbol)).collect(Collectors.toList()));
                    }else {
                        int length = Integer.parseInt(input[2]);
                        people.addAll(people.stream().filter(name -> name.length() == length).collect(Collectors.toList()));
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        Collections.sort(people);
        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(people.toString().replaceAll("[\\[\\]]","") + " are going to the party!");
        }
    }
}

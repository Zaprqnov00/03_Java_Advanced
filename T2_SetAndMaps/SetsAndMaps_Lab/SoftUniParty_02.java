package SetsAndMapsLab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regularGuests = new HashSet<>();
        Set<String> vipGuests = new HashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("PARTY")){
            char symbol = command.charAt(0);
            if (Character.isDigit(symbol)){
                vipGuests.add(command);
            }else {
                regularGuests.add(command);
            }
            command = scanner.nextLine();
        }

        String checkGuests = scanner.nextLine();
        while (!checkGuests.equals("END")){
            if (regularGuests.contains(checkGuests)){
                regularGuests.remove(checkGuests);
            }
            if (vipGuests.contains(checkGuests)){
                vipGuests.remove(checkGuests);
            }

            checkGuests = scanner.nextLine();
        }

        System.out.println(regularGuests.size() + vipGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }
}

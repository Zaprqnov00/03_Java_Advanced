package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountUpperCase_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");

        List<String> upperCaseWords = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            char symbol = text[i].charAt(0);
            if (Character.isUpperCase(symbol)){
                upperCaseWords.add(text[i]);
            }
        }
        System.out.println(upperCaseWords.size());
        for (String word :upperCaseWords) {
            System.out.println(word);
        }
    }
}

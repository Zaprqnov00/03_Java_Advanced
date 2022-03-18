package SetsAndMapsExercices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbol_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!characterIntegerMap.containsKey(symbol)){
                characterIntegerMap.put(symbol,1);
            }else {
                int currentValue = characterIntegerMap.get(symbol);
                characterIntegerMap.put(symbol,currentValue + 1);
            }
        }

        characterIntegerMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%c: %d time/s\n",entry.getKey(),entry.getValue()));
    }
}

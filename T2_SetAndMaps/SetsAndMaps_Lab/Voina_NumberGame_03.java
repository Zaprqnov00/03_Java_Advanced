package SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstDeck = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] secondDeck = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();

        for (int card :firstDeck) {
            firstPlayerCards.add(card);
        }
        for (int card :secondDeck) {
            secondPlayerCards.add(card);
        }

        for (int rounds = 0; rounds < 50; rounds++) {
            if (firstPlayerCards.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayerCards.isEmpty()){
                System.out.println("First player win!");
                return;
            }

            int cardFirstPlayer = firstPlayerCards.iterator().next();
            int cardSecondPlayer = secondPlayerCards.iterator().next();
            firstPlayerCards.remove(cardFirstPlayer);
            secondPlayerCards.remove(cardSecondPlayer);

            if (cardFirstPlayer > cardSecondPlayer) {
                firstPlayerCards.add(cardFirstPlayer);
                firstPlayerCards.add(cardSecondPlayer);
            } else if (cardFirstPlayer < cardSecondPlayer) {
                secondPlayerCards.add(cardFirstPlayer);
                secondPlayerCards.add(cardSecondPlayer);
            } else {
                firstPlayerCards.add(cardFirstPlayer);
                secondPlayerCards.add(cardSecondPlayer);
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if (firstPlayerCards.size() < secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}

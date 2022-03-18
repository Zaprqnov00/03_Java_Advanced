package StackAndQueues_Exam;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputFirstBox = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] inputSecondBox = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        ArrayDeque<Integer> offerFirstBox = new ArrayDeque<>();
        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();

        List<Integer> collectionItems = new ArrayList<>();

        for (int item : inputFirstBox) {
            offerFirstBox.offer(item);
        }
        for (int item : inputSecondBox) {
            stackSecondBox.push(item);
        }

        while (!offerFirstBox.isEmpty() && !stackSecondBox.isEmpty()) {
            int firstItem = offerFirstBox.peek();
            int secondItem = stackSecondBox.peek();
            int sum = firstItem + secondItem;

            fillItems(offerFirstBox, stackSecondBox, collectionItems, sum);
        }

        printFinalResults(offerFirstBox, stackSecondBox, collectionItems);
    }

    private static void printFinalResults(ArrayDeque<Integer> offerFirstBox, ArrayDeque<Integer> stackSecondBox, List<Integer> collectionItems) {
        if (offerFirstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (stackSecondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sumCollectionItems = collectionItems.stream().mapToInt(e -> e).sum();

        if (sumCollectionItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumCollectionItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumCollectionItems);
        }
    }

    private static void fillItems(ArrayDeque<Integer> offerFirstBox, ArrayDeque<Integer> stackSecondBox, List<Integer> collectionItems, int sum) {
        if (sum % 2 == 0) {
            collectionItems.add(sum);
            offerFirstBox.poll();
            stackSecondBox.pop();
        } else {
            offerFirstBox.offer(stackSecondBox.pop());
        }
    }
}

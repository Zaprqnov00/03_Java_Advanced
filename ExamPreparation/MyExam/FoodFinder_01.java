package Exam_19_02_2022;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputVowels = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> inputConsonants = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        for (String vowel :inputVowels) {
            vowelsQueue.offer(vowel);
        }
        for (String cons :inputConsonants) {
            consonantsStack.push(cons);
        }

        String pear = "pear";
        List<String> pearList = Arrays.stream(pear.split("")).collect(Collectors.toList());

        String flour = "flour";
        List<String> flourList = Arrays.stream(flour.split("")).collect(Collectors.toList());

        String pork = "pork";
        List<String> porkList = Arrays.stream(pork.split("")).collect(Collectors.toList());

        String olive = "olive";
        List<String> oliveList  = Arrays.stream(olive.split("")).collect(Collectors.toList());

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            fillFlour(oliveList, vowel, consonant);

            fillFlour(porkList, vowel, consonant);

            fillFlour(pearList, vowel, consonant);

            fillFlour(flourList, vowel, consonant);

            vowelsQueue.offer(vowel);
        }

        int count = 0;
        if (pearList.isEmpty()){
            count++;
        }
        if (flourList.isEmpty()){
            count++;
        }
        if (porkList.isEmpty()){
            count++;
        }
        if (oliveList.isEmpty()){
            count++;
        }

        System.out.println("Words found: " + count);
        if (pearList.isEmpty()){
            System.out.println("pear");
        }
        if (flourList.isEmpty()){
            System.out.println("flour");
        }
        if (porkList.isEmpty()){
            System.out.println("pork");
        }
        if (oliveList.isEmpty()){
            System.out.println("olive");
        }
    }

    private static void fillFlour(List<String> flourList, String vowel, String consonant) {
        if (!flourList.isEmpty()) {
            if (flourList.contains(vowel)) {
                flourList.remove(vowel);
            }
            if (flourList.contains(consonant)) {
                flourList.remove(consonant);
            }
        }
    }
}

package StackAndQueues_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputIngredients = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inputFreshLevel = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int pearSour = 0; // 150
        int harvest = 0; // 250
        int appleHinny = 0; // 300
        int highFashion = 0; // 400

        ArrayDeque<Integer> offerIngredients = new ArrayDeque<>();
        ArrayDeque<Integer> stackFreshLevel = new ArrayDeque<>();

        for (int ingredient :inputIngredients) {
            offerIngredients.offer(ingredient);
        }
        for (int fresh :inputFreshLevel) {
            stackFreshLevel.push(fresh);
        }

        while (!offerIngredients.isEmpty() && !stackFreshLevel.isEmpty()){
            int ingredient = offerIngredients.peek();
            int freshLevel = stackFreshLevel.peek();
            int sum = ingredient * freshLevel;

            if (ingredient == 0){
                offerIngredients.poll();
                continue;
            }

            if (sum == 150){
                pearSour++;
                offerIngredients.poll();
                stackFreshLevel.pop();
            }else if (sum == 250){
                harvest++;
                offerIngredients.poll();
                stackFreshLevel.pop();
            }else if (sum == 300){
                appleHinny++;
                offerIngredients.poll();
                stackFreshLevel.pop();
            }else if (sum == 400){
                highFashion++;
                offerIngredients.poll();
                stackFreshLevel.pop();
            }else {
                stackFreshLevel.pop();
                int currentIngredient = offerIngredients.poll() + 5;
                offerIngredients.offer(currentIngredient);
            }
        }

        if (pearSour >= 1 && harvest >= 1 && appleHinny >= 1 && highFashion >= 1){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!offerIngredients.isEmpty()){
            int sumIngredient = 0;
            for (int ingredient :offerIngredients) {
                sumIngredient += ingredient;
            }
            System.out.println("Ingredients left: " + sumIngredient);
        }

        if (appleHinny > 0) {
            System.out.println(" # Apple Hinny --> " + appleHinny);
        }
        if (highFashion > 0) {
            System.out.println(" # High Fashion --> " + highFashion);
        }
        if (pearSour > 0) {
            System.out.println(" # Pear Sour --> " + pearSour);
        }
        if (harvest > 0) {
            System.out.println(" # The Harvest --> " + harvest);
        }
    }
}

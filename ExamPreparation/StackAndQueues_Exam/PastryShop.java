package StackAndQueues_Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLiquids = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int[] inputIngredients = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        ArrayDeque<Integer> liquidsOffer = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();

        for (int i = 0; i < inputLiquids.length; i++) {
            liquidsOffer.offer(inputLiquids[i]);
        }
        for (int i = 0; i < inputIngredients.length; i++) {
            ingredientStack.push(inputIngredients[i]);
        }

        int biscuit = 0; //25
        int cake = 0; //50
        int pastry = 0; //75
        int pie = 0; //100

        while (!liquidsOffer.isEmpty() && !ingredientStack.isEmpty()){
            int liquid = liquidsOffer.peek();
            int ingredient = ingredientStack.peek();
            int sum = liquid + ingredient;

            if (sum == 25){
                biscuit++;
                liquidsOffer.poll();
                ingredientStack.pop();
            }else if (sum == 50){
                cake++;
                liquidsOffer.poll();
                ingredientStack.pop();
            }else if (sum == 75){
                pastry++;
                liquidsOffer.poll();
                ingredientStack.pop();
            }else if (sum == 100){
                pie++;
                liquidsOffer.poll();
                ingredientStack.pop();
            }else {
                liquidsOffer.poll();
                ingredientStack.push(ingredientStack.pop() + 3);
            }
        }

        if (biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsOffer.isEmpty()){
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + liquidsOffer.toString().replaceAll("[\\[\\]]",""));
        }

        if (ingredientStack.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            System.out.println("Ingredients left: " + ingredientStack.toString().replaceAll("[\\[\\]]",""));
        }

        System.out.println("Biscuit: " + biscuit);
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);
    }
}

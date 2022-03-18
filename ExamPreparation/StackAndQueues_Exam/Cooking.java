package StackAndQueues_Exam;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquidInput = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> ingredientInput = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int bread = 0; //25
        int cake = 0; //50
        int pastry = 0; //75
        int fruitPie = 0; //100

        while (!liquidInput.isEmpty() && !ingredientInput.isEmpty()){
            int liquid = liquidInput.get(0);
            int ingredient = ingredientInput.get(ingredientInput.size() - 1);
            int sum = liquid + ingredient;

            if (sum == 25){
                bread++;
                liquidInput.remove(0);
                ingredientInput.remove(ingredientInput.size() - 1);
            }else if (sum == 50){
                cake++;
                liquidInput.remove(0);
                ingredientInput.remove(ingredientInput.size() - 1);
            }else if (sum == 75){
                pastry++;
                liquidInput.remove(0);
                ingredientInput.remove(ingredientInput.size() - 1);
            }else if (sum == 100){
                fruitPie++;
                liquidInput.remove(0);
                ingredientInput.remove(ingredientInput.size() - 1);
            }else {
                liquidInput.remove(0);
                int currentValue = ingredientInput.get(ingredientInput.size() - 1) + 3;
                ingredientInput.set(ingredientInput.size() - 1,currentValue);
            }
        }

        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidInput.isEmpty()) {
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + liquidInput.toString().replaceAll("[\\[\\]]",""));
        }

        if (ingredientInput.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {
            Collections.reverse(ingredientInput);
            System.out.println("Ingredients left: " + ingredientInput.toString().replaceAll("[\\[\\]]",""));
        }
        Map<String,Integer> cookItems = new TreeMap<>();
        cookItems.put("Bread",bread);
        cookItems.put("Cake",cake);
        cookItems.put("Pastry",pastry);
        cookItems.put("Fruit Pie",fruitPie);

        cookItems.entrySet().forEach(entry -> System.out.printf("%s: %d\n",entry.getKey(),entry.getValue()));
    }
}

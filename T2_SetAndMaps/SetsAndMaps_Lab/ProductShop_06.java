package SetsAndMapsLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Double>> shopsMap = new TreeMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Revision")){
            String[] input = command.split(", ");
            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            if (!shopsMap.containsKey(shop)){
                shopsMap.put(shop,new LinkedHashMap<>());
                shopsMap.get(shop).put(product,price);
            }else {
                shopsMap.get(shop).put(product,price);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : shopsMap.entrySet()) {
            System.out.println(entry.getKey() + "->");
            entry.getValue().entrySet()
                    .forEach(secondEntry -> System.out.printf("Product: %s, Price: %.1f\n",secondEntry.getKey(),secondEntry.getValue()));
        }

    }
}

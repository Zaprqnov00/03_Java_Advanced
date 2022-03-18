package SetsAndMapsLab;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumber_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());

        Map<Double,Integer> realNumbersMap = new LinkedHashMap<>();

        for (int i = 0; i < numbers.size(); i++) {

            if (!realNumbersMap.containsKey(numbers.get(i))){
                realNumbersMap.put(numbers.get(i),1);
            }else {
                int currentCount = realNumbersMap.get(numbers.get(i));
                realNumbersMap.put(numbers.get(i),currentCount + 1);
            }
        }

        realNumbersMap.entrySet()
                .forEach(entry -> System.out.printf("%.1f -> %d\n",entry.getKey(),entry.getValue()));
    }
}

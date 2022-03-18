package SetsAndMapsLab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String, List<String>>> informationMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!informationMap.containsKey(continent)){
                informationMap.put(continent, new LinkedHashMap<>());
                informationMap.get(continent).put(country,new ArrayList<>());
                informationMap.get(continent).get(country).add(city);
            }else {
                if (!informationMap.get(continent).containsKey(country)){
                    informationMap.get(continent).put(country,new ArrayList<>());
                    informationMap.get(continent).get(country).add(city);
                }else {
                    informationMap.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : informationMap.entrySet()) {
            System.out.println(entry.getKey() + ":");

            for (Map.Entry<String, List<String>> secondEntry : entry.getValue().entrySet()) {

                System.out.printf("  %s -> ",secondEntry.getKey());
                System.out.println(secondEntry.getValue().toString().replaceAll("[\\[\\]]",""));
            }

        }

    }
}

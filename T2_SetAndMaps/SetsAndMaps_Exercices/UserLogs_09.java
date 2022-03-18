package SetsAndMapsExercices;

import java.util.*;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String, List<String>>> usersLogMap = new TreeMap<>();

        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] input = command.split("[ =]+");
            String ip = input[1];
            String message = input[3];
            String username = input[5];

            if (!usersLogMap.containsKey(username)){
                usersLogMap.put(username,new LinkedHashMap<>());
                usersLogMap.get(username).put(ip,new ArrayList<>());
                usersLogMap.get(username).get(ip).add(message);
            }else {
                if (usersLogMap.get(username).containsKey(ip)){
                    usersLogMap.get(username).get(ip).add(message);
                }else {
                    usersLogMap.get(username).put(ip,new ArrayList<>());
                    usersLogMap.get(username).get(ip).add(message);
                }
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : usersLogMap.entrySet()) {
            System.out.println(entry.getKey() + ": ");

            int count = entry.getValue().size();
            for (Map.Entry<String, List<String>> setEntry : entry.getValue().entrySet()) {
                if (count > 1){
                    System.out.printf("%s => %s, ",setEntry.getKey(),setEntry.getValue().size());
                    count--;
                }else {
                    System.out.printf("%s => %s.",setEntry.getKey(),setEntry.getValue().size());
                }
            }

        }

    }
}

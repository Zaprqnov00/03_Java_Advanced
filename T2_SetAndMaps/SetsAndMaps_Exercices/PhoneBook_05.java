package SetsAndMapsExercices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phoneBook = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("search")){
            String[] data = command.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            phoneBook.put(name,phoneNumber);

            command = scanner.nextLine();
        }

        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")){

            if (phoneBook.containsKey(searchName)){
                System.out.printf("%s -> %s\n",searchName,phoneBook.get(searchName));
            }else {
                System.out.printf("Contact %s does not exist.\n",searchName);
            }

            searchName = scanner.nextLine();
        }
    }
}

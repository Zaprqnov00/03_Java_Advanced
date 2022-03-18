package SetsAndMapsExercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listUsernames = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String usernames = scanner.nextLine();

            if (!listUsernames.contains(usernames)){
                listUsernames.add(usernames);
            }
        }

        for (String name :listUsernames) {
            System.out.println(name);
        }
    }
}

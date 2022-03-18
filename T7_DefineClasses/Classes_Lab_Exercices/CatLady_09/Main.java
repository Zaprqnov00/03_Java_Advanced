package ClassesExercices.CatLady_09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> catList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] catsInfo = input.split(" ");
            String breed = catsInfo[0];
            String name = catsInfo[1];
            double characteristic = Double.parseDouble(catsInfo[2]);

            Cat cat = new Cat(breed,name,characteristic);
            catList.add(cat);

            input = scanner.nextLine();
        }

        String searchedCat = scanner.nextLine();

        for (Cat cats :catList) {
            if (cats.getName().equals(searchedCat)){
                System.out.println(cats);
                return;
            }
        }
    }
}

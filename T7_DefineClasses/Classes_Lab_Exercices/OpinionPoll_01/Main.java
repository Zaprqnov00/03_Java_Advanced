package ClassesExercices.OpinionPoll_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Person person = new Person();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (age > 30){
                person.put(name,age);
            }
        }

        System.out.println(person);
    }
}

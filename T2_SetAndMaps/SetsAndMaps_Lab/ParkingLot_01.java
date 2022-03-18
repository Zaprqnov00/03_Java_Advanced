package SetsAndMapsLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Set<String> carSet = new LinkedHashSet<>();

        while(!command.equals("END")){
            String[] input = command.split(", ");
            String move = input[0];
            String carNumber = input[1];

            if (move.equals("IN")){
                carSet.add(carNumber);
            }else {
                carSet.remove(carNumber);
            }

            command = scanner.nextLine();
        }

        if (carSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            carSet.forEach(System.out::println);
        }
    }
}

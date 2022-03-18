package ClassesExercices.RawData_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int enginePower = Integer.parseInt(input[2]);
            String cargoType = input[4];
            Car car = new Car(model,enginePower,cargoType,new ArrayList<>());
            car.add(Double.parseDouble(input[5]));
            car.add(Double.parseDouble(input[7]));
            car.add(Double.parseDouble(input[9]));
            car.add(Double.parseDouble(input[11]));
            carList.add(car);

        }
        String command = scanner.nextLine();

        if (command.equals("fragile")){
            for (Car car :carList) {
                List<Double> tires = car.getTires();
                for (double tire :tires) {
                    if (car.getCargo().equals("fragile") && tire < 1){
                        System.out.println(car.getModel());
                        break;
                    }
                }
            }
        }else if (command.equals("flamable")){
            for (Car car :carList) {
                if (car.getCargo().equals("flamable") && car.getEngine() > 250){
                    System.out.println(car.getModel());
                }
            }
        }
    }
}

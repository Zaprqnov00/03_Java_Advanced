package ClassesExercices.SpeedRacing_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         Set<Car> carsInformationMap = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost = Double.parseDouble(input[2]);

            Car car = new Car(model,fuelAmount,fuelCost,0);
            carsInformationMap.add(car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] input = command.split(" ");
            switch (input[0]){
                case "Drive":
                    String carModel = input[1];
                    int amountKilometres = Integer.parseInt(input[2]);
                        for (Car car : carsInformationMap) {
                            if (carModel.equals(car.getModel())){
                                double sumDecreaseKm = amountKilometres * car.getFuelCost();
                                if (sumDecreaseKm <= car.getFuelAmount()){
                                    car.setFuelAmount(car.getFuelAmount() - sumDecreaseKm);
                                    car.setDistance(car.getDistance() + amountKilometres);
                                }else {
                                    System.out.println("Insufficient fuel for the drive");
                                }
                            }
                    }

                    break;
            }
            command = scanner.nextLine();
        }

            for (Car car: carsInformationMap) {
                    System.out.printf("%s %.2f %d\n",car.getModel(),car.getFuelAmount(),car.getDistance());
            }

    }
}

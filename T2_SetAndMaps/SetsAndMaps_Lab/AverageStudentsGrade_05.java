package SetsAndMapsLab;

import java.util.*;

public class AverageStudentsGrade_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentInformationMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentInformationMap.containsKey(student)){
                studentInformationMap.put(student,new ArrayList<>());
                studentInformationMap.get(student).add(grade);
            }else {
                studentInformationMap.get(student).add(grade);
            }
        }

        Map<String,Double> averageGradesMap = new TreeMap<>();
        for (Map.Entry<String, List<Double>> entry : studentInformationMap.entrySet()) {

            double allGrade = 0;
            for (double grade :entry.getValue()) {
                allGrade += grade;
            }
            double averageGrade = allGrade / entry.getValue().size();
            averageGradesMap.put(entry.getKey(),averageGrade);
        }

        studentInformationMap.entrySet()
                .forEach(entry -> {
                    System.out.print(entry.getKey() + " -> ");
                    for (double grades : entry.getValue()) {
                        System.out.printf("%.2f ",grades);
                    }
                    System.out.printf("(avg: %.2f)\n",averageGradesMap.get(entry.getKey()));
                });
    }
}

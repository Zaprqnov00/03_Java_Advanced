package SetsAndMapsLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,List<Double>> mapWithStudent = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

            if (!mapWithStudent.containsKey(studentName)){
                mapWithStudent.put(studentName,new ArrayList<>());
                for (double grade :grades) {
                    mapWithStudent.get(studentName).add(grade);
                }
            }else {
                for (double grade :grades) {
                    mapWithStudent.get(studentName).add(grade);
                }
            }
        }

        Map<String,Double> mapWithAverageGrades = new TreeMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.###################");
        for (Map.Entry<String, List<Double>> entry : mapWithStudent.entrySet()) {

            double gradesPerStudent = 0;
            double averageGrade = 0;
            for (double grade : entry.getValue()) {
                gradesPerStudent += grade;
            }
            averageGrade += gradesPerStudent / entry.getValue().size();
            mapWithAverageGrades.put(entry.getKey(), averageGrade);
        }

        for (Map.Entry<String, Double> entry : mapWithAverageGrades.entrySet()) {
            String formatGrade = decimalFormat.format(entry.getValue());

            System.out.printf("%s is graduated with %s\n",entry.getKey(),formatGrade);
        }

    }
}

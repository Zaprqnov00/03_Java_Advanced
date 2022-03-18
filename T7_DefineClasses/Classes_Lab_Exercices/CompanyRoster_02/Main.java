package ClassesExercices.CompanyRoster_02;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> employeeMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                Employee employee = new Employee(name,salary,position,department,email,age);
                employeeMap.put(name,new ArrayList<>());
                employeeMap.get(name).add(employee);
            }else if (input.length == 4){
                Employee employee = new Employee(name,salary,position,department,"n/a",-1);
                employeeMap.put(name,new ArrayList<>());
                employeeMap.get(name).add(employee);
            }else if (input.length == 5 && input[4].contains("@")){
                String email = input[4];
                Employee employee = new Employee(name,salary,position,department,email,-1);
                employeeMap.put(name,new ArrayList<>());
                employeeMap.get(name).add(employee);
            }else {
                int age = Integer.parseInt(input[4]);
                Employee employee = new Employee(name,salary,position,department,"n/a",age);
                employeeMap.put(name,new ArrayList<>());
                employeeMap.get(name).add(employee);
            }
        }

        Map<String,List<Double>> salaryMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<Employee>> entry : employeeMap.entrySet()) {
            for (Employee person : entry.getValue()) {
                if (!salaryMap.containsKey(person.getDepartment())){
                    salaryMap.put(person.getDepartment(),new ArrayList<>());
                    salaryMap.get(person.getDepartment()).add(person.getSalary());
                }else {
                    salaryMap.get(person.getDepartment()).add(person.getSalary());
                }
            }
        }

        Map<String,Double> averageSalaryMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : salaryMap.entrySet()) {
            double allSalary = 0;
            for (double salary : entry.getValue()) {
                allSalary += salary;
            }
            double averageSalary = allSalary / entry.getValue().size();
            averageSalaryMap.put(entry.getKey(),averageSalary);
        }


        Map<String ,Double> employeeFirm = new LinkedHashMap<>();
        averageSalaryMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(1)
                .forEach(entry -> {
                    System.out.printf("Highest Average Salary: %s\n", entry.getKey());
                    for (Map.Entry<String, List<Employee>> setEntry : employeeMap.entrySet()) {
                        for (Employee person : setEntry.getValue()) {
                            if (entry.getKey().equals(person.getDepartment())){
                               employeeFirm.put(person.getName(),person.getSalary());
                            }
                        }
                    }
                });

        employeeFirm.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for (Map.Entry<String, List<Employee>> secondEntry : employeeMap.entrySet()) {
                        for (Employee person : secondEntry.getValue()) {
                            if (entry.getKey().contains(person.getName())){
                                System.out.printf("%s %.2f %s %d\n",person.getName(),person.getSalary(),person.getEmail(),person.getAge());
                            }
                        }
                    }

                });
    }
}

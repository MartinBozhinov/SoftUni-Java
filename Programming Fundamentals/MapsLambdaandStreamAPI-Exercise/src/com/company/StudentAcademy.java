package com.company;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int n = Integer.parseInt(scanner.nextLine());

         Map<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!map.containsKey(studentName)){
                map.put(studentName, new ArrayList<>());
                map.get(studentName).add(grade);
            }else {
                map.get(studentName).add(grade);

            }
        }
           Map<String, Double> averageGrade = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
            if (average >= 4.50){
             averageGrade.put(entry.getKey(), average);

            }

        }
        averageGrade.entrySet()
                .stream()
                .sorted((g1,g2) -> g2.getValue()
                        .compareTo(g1.getValue()))
                .forEach(grade -> {
                    System.out.printf("%s -> %.2f%n", grade.getKey(),grade.getValue());
                });

    }
}

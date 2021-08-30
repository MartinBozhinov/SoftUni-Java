package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGrade = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            studentGrade.putIfAbsent(name, new LinkedList<>());
            studentGrade.get(name).add(grade);
        }
        studentGrade.forEach((name,grades) -> {
               String allGrades = grades.stream()
                       .map(g -> String.format("%.2f", g))
                       .collect(Collectors.joining(" "));
               double avg = grades.stream().mapToDouble(e->e).average().orElse(0d);
            System.out.println(String.format("%s -> %s (avg: %.2f)", name , allGrades , avg));
        });
    }
}

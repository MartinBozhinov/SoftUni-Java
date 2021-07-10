package com.company;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new LinkedHashMap<>();
       int counter = 0;
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] splitedInput = input.split(" : ");
            String course = splitedInput[0];
            String student = splitedInput[1];
            int initialCourseCounter = 0;
            if (map.containsKey(course)){
               List<String> names = map.get(course);
               names.add(student);
               map.put(course,names);
               initialCourseCounter++;
               counter += initialCourseCounter;

            }else{
              List<String> names = new ArrayList<>();
              names.add(student);
              map.put(course,names);
            }
            input = scanner.nextLine();
        }
         map.entrySet()
                 .stream()
                 .sorted((e1,e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                 .forEach(entry -> {
                      System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                        entry.getValue()
                                .stream()
                                .sorted((s1,s2) -> s1.compareTo(s2))
                                .forEach(s -> System.out.println(String.format("-- %s", s)));

                 });

    }
}

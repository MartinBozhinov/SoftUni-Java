package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BiPredicate<Map.Entry<String,Integer>, Integer> isOlder = (person, age) -> person.getValue() >= age;
        BiPredicate<Map.Entry<String,Integer>, Integer> isYounger = (person, age) -> person.getValue() < age;
        Consumer<Map.Entry<String,Integer>> printName = person -> System.out.println(person.getKey());
        Consumer<Map.Entry<String,Integer>> printAge = person -> System.out.println(person.getValue());
        Consumer<Map.Entry<String,Integer>> printNameAndAge = person -> System.out.printf("%s - %d%n",person.getKey(),person.getValue());



        Map<String, Integer> nameAndAge = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            nameAndAge.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        nameAndAge.entrySet().stream()
                .filter(person -> condition.equalsIgnoreCase("younger") ?
                isYounger.test(person,age) :
                isOlder.test(person,age))
                .forEach(person -> {
                    if (format.equalsIgnoreCase("age")){
                            printAge.accept(person);
                    }else if (format.equalsIgnoreCase("name")){
                        printName.accept(person);
                    }else {
                        printNameAndAge.accept(person);
                    }
                });




    }

}

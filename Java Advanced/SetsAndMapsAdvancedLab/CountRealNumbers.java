package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<Double, Integer> values = new LinkedHashMap<>();

        for (String string : input) {
            if (!values.containsKey(Double.parseDouble(string))) {
                values.put(Double.parseDouble(string), 1);
            } else {
                values.put(Double.parseDouble(string), values.get(Double.parseDouble(string)) + 1);
            }

        }

        for (Map.Entry<Double, Integer> integerEntry : values.entrySet()) {
            System.out.printf("%.1f -> %d%n", integerEntry.getKey(),integerEntry.getValue());
        }

    }


}

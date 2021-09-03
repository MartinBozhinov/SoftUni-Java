package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);
            if (!result.containsKey(ch)) {
                result.put(ch, 1);
            } else {
                result.put(ch, result.get(ch)+1);
            }

        }
        result.forEach((k,v) -> {
            System.out.println(String.format("%c: %d time/s", k,v));
        });
    }
}

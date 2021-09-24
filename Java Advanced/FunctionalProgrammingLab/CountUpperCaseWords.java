package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] splitedInput = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithCapital = x -> Character.isUpperCase(x.charAt(0));

        List<String> words = Arrays.stream(splitedInput)
                .filter(isStartingWithCapital).collect(Collectors.toList());

        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}

package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] splitedInput = scanner.nextLine().split(", ");

        List<String> sortedNumbers = Arrays.stream(splitedInput)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        String sorted = String.join(", ", sortedNumbers);
        System.out.println(sorted);

          List<Integer> afterSorting = sortedNumbers.stream()
                 .map(Integer::parseInt)
                 .sorted((e,f) -> e.compareTo(f)).collect(Collectors.toList());

          List<String> afterrS = afterSorting.stream().map(String::valueOf).collect(Collectors.toList());

          sorted = String.join(", ", afterrS);
        System.out.println(sorted);


    }
}

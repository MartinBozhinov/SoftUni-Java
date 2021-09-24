package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String[] inputSplited = scanner.nextLine().split(", ");

        Function<String,Integer> parse = Integer::parseInt;

        List<Integer> collect = Arrays.stream(inputSplited)
                .map(parse)
                .collect(Collectors.toList());
        System.out.println("Count = "+collect.size());

        int sum = collect.stream().reduce(0, (a,b) -> a+b);

        System.out.println("Sum = "+sum);


    }
}

package com.company;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
           Predicate<Integer> isEven = x -> x % 2 == 0;
           Predicate<Integer> isOdd = x -> x % 2 != 0;
        String[] input = scanner.nextLine().split("\\s+");

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);
        String condition = scanner.nextLine();

         Predicate<Integer> byType = isEven;
        if (condition.equalsIgnoreCase("odd")){
            byType = isOdd;
        }

        IntStream
                .rangeClosed(lowerBound,upperBound)
                .boxed()
                .filter(byType)
                .forEach(x -> System.out.print(x + " "));
    }
}

package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddingVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] splitedInput = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = d -> 1.2 * d;
        System.out.println("Prices with VAT:");
        Arrays.stream(splitedInput).map(Double::parseDouble).map(addVat).forEach(d -> System.out.printf("%.2f%n", d));

    }
}

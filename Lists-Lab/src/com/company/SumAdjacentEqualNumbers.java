package com.company;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        double sum = 0;
        for (int i = 0; i < numbers.size() -1 ; i++) {
            double firstNumber = numbers.get(i);
            double secondNumber = numbers.get(i + 1);
            if (firstNumber == secondNumber) {
                sum = firstNumber + secondNumber;
                numbers.set(i, sum);
                numbers.remove(i + 1);
                i = -1;
            }

        }
        String output = concatElements(numbers, " ");
        System.out.println(output);



    }

    private static String concatElements(List<Double> numbers, String delimeter) {

        String output = "";

        for (Double num : numbers){
            output += (new DecimalFormat("0.#").format(num) + delimeter);


        }

        return output;
    }
}


package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int totalSize = numbers.size();

        for (int i = 0; i < numbers.size() ; i++) {
            if (i == numbers.size() -1){
                break;
            }
            int lastNumber = numbers.get(numbers.size()- 1 );
            int sum = numbers.get(i) + lastNumber;
            numbers.set(i, sum);
            numbers.remove(numbers.size()-1);
        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));




    }
}

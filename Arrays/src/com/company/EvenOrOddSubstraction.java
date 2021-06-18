package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOrOddSubstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]%2 ==0){
                evenSum += arr[i];
            }else if (arr[i]%2 != 0){
                oddSum += arr[i];
            }
        }

        System.out.println(evenSum-oddSum);
    }
}

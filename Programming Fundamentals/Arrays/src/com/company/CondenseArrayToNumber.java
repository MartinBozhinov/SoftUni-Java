package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] condensed = new int[arr.length-1];

        for (int i = 0; i < arr.length-1; i++) {
            condensed[i] = arr[i] + arr[i+1];

        }
        for (int i = 0; i <condensed.length-1 ; i++) {
            condensed[i] += condensed[i+1];
            
        }


    }
}

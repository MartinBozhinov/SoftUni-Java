package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int firstNumber = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = firstNumber;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

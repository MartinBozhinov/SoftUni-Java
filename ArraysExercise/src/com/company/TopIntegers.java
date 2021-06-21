package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <arr.length- 1 ; i++) {
            int firstNumber = arr[i+1];
            if (arr[i] <= firstNumber){
                continue;
            }
            else{
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print(arr[arr.length-1]);
    }
}

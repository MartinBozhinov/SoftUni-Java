package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] arrOne = new int[n];
        int[] arrTwo = new int [n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 1){
                arrOne[i] = input[0];
                arrTwo[i] = input[1];
            }
            else {
                arrTwo[i] = input[0];
                arrOne[i] = input[1];
            }
        }
        for (int i = 0; i <arrTwo.length ; i++) {
            System.out.print(arrTwo[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <arrOne.length ; i++) {
            System.out.print(arrOne[i] + " ");
        }





    }
}

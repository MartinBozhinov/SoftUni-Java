package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSUms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            rightSum += numbers[i];

        }
        for (int i = 0; i < numbers.length; i++) {
            rightSum -= numbers[i];
            if (rightSum == leftSum){
                System.out.print(i);
                return;
            }
            leftSum += numbers[i];
        }
        System.out.println("no");

    }
}

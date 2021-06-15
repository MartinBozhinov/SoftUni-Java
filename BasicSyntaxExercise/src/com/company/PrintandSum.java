package com.company;

import java.util.Scanner;

public class PrintandSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNumber = sc.nextInt();
        int endNumber = sc.nextInt();
        int sum = 0;
        for (int i = startNumber; i <=endNumber ; i++) {
            System.out.printf(i + " ");
            sum += i;
        }
        System.out.printf("%n");
        System.out.printf("Sum: %d", sum);
    }
}

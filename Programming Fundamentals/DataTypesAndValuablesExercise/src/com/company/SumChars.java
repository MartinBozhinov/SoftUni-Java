package com.company;
import java.util.Scanner;


public class SumChars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            String letter = scanner.nextLine();
            int ascii = letter.charAt(0);
            sum += ascii;

        }

        System.out.printf("The sum equals: %d", sum);
    }

}
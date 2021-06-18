package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOFStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = input.length-1; i >= 0 ; i--) {
            System.out.print(input[i] + " ");
        }

    }
}

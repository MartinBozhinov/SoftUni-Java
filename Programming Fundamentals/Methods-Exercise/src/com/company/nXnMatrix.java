package com.company;

import java.util.Scanner;

public class nXnMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
package com.company;

import java.util.Scanner;

public class AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());


        sum(a,b);
        subtract(sum(a,b),c);
    }

    private static int subtract(int sum, int c) {
        int total = sum - c;
        System.out.println(total);
        return total;
    }

    private static int sum(int a, int b) {
        int sum = a + b;
        return sum;

    }
}

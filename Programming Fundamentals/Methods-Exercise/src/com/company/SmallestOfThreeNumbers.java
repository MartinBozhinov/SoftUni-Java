package com.company;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        smallestNumber(a,b,c);
        System.out.println(smallestNumber(a,b,c));

    }

    private static int smallestNumber(int a, int b, int c) {
        int smaller = 0;

        if (a <= b && a <= c){
          smaller = a;
        }
        else if (b<=a && b <= c){
            smaller =b;
        }
        else if (c<=a && c<=b){
            smaller =c;
        }
        return smaller;
    }
}

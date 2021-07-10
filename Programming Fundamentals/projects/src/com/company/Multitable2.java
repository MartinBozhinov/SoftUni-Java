package com.company;

import java.util.Scanner;

public class Multitable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int times = sc.nextInt();
        if (times > 10){
            System.out.printf("%d X %d = %d%n", number, times, number * times);
             return;
        }
        for (int i = times; i <= 10; i++) {

            System.out.printf("%d X %d = %d%n", number, i, number * i);


        }

    }
}

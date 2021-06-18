package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int wagons = Integer.parseInt(scanner.nextLine());
        int[] train = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            int ppl = Integer.parseInt(scanner.nextLine());
            train[i] = ppl;
            sum += train[i];
        }

        for (int i = 0; i <train.length ; i++) {
            System.out.print(train[i]);
        }
        System.out.println(sum);

    }
}

package com.company;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (product){
            case "coffee":
                price = 1.50;
                coffePrice(quantity, price);
                break;
            case "water":
                price = 1.00;
                waterPrice(quantity,price);
                break;
            case "coke":
                price = 1.40;
                cokePrice(quantity,price);
                break;
            case "snacks":
                price = 2.00;
                snacksPrice(quantity,price);
                break;

        }
    }

    private static void snacksPrice(int quantity, double price) {
        double sum = quantity*price;
        System.out.printf("%.2f", sum);
    }

    private static void cokePrice(int quantity, double price) {
        double sum = quantity*price;
        System.out.printf("%.2f", sum);
    }

    private static void waterPrice(int quantity, double price) {
        double sum = quantity*price;
        System.out.printf("%.2f", sum);
    }

    private static void coffePrice(int quantity, double price) {
        double sum = quantity * price;
        System.out.printf("%.2f", sum);
    }
}

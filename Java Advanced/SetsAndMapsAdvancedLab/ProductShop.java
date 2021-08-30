package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
         Map<String, Map<String,Double>> shopAndProducts = new TreeMap<>();

        while   (!input.equalsIgnoreCase("Revision")){
        String[] splitedInput = input.split(", ");

        String shopName = splitedInput[0];
        String product = splitedInput[1];
        double price = Double.parseDouble(splitedInput[2]);
        shopAndProducts.putIfAbsent(shopName, new LinkedHashMap<>());
        shopAndProducts.get(shopName).putIfAbsent(product,price);
        input = scanner.nextLine();
        }

        shopAndProducts.forEach((shopname , product) -> {
            System.out.println(shopname + "->");
            product.forEach((productName,price) -> {
                System.out.println(String.format("Product: %s, Price: %.1f", productName, price));
            });
        });


    }
}

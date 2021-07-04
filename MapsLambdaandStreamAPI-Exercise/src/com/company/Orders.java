package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        Map<String, Double> productPrice = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String[] splitedInput = input.split("\\s+");
            String product = splitedInput[0];
            double price = Double.parseDouble(splitedInput[1]);
            int quantity = Integer.parseInt(splitedInput[2]);


            productPrice.put(product, price);
                productQuantity.putIfAbsent(product, 0);
                int newQuantity = productQuantity.get(product) + quantity;
                productQuantity.put(product, newQuantity);

           input = scanner.nextLine();
        }

        productQuantity.forEach((k,v) -> System.out.println(String.format("%s -> %.2f", k,v * productPrice.get(k))));
    }
}

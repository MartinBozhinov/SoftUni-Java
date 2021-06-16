package com.company;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var numBeer = Integer.parseInt(scanner.nextLine());

        double biggestKeg = Double.MIN_VALUE;
        String modelBeer = "";
        String biggestBeer = "";
        for (int i = 1; i <= numBeer ; i++) {
            modelBeer = scanner.nextLine();
            var radius = Double.parseDouble(scanner.nextLine());
            var height = Integer.parseInt(scanner.nextLine());
            double volumeKeg = Math.PI * radius * radius * height;
            if (volumeKeg > biggestKeg){
              biggestKeg = volumeKeg;
              biggestBeer = modelBeer;
            }
        }
        System.out.print(biggestBeer);
    }
}

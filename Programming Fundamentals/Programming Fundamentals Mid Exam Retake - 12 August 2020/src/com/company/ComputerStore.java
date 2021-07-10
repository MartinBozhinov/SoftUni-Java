package com.company;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double price = 0;
        double number = 0;
        double taxes = 0;

        while (!"special".equals(input) || !"regular".equals(input)){
            if (input.equals("special")){
                break;
            }
            if (input.equals("regular")){
                break;
            }

            number = Double.parseDouble(input);
                if (number <= 0){
                    System.out.println("Invalid price!");
                    input = scanner.nextLine();
                    continue;
                }
                taxes += number * 20 / 100;
                price += number;

            input = scanner.nextLine();

        }


            double totalPrice = 0;
            totalPrice = taxes+price ;
        if (totalPrice==0){
            System.out.println("Invalid order!");
            return;
        }
        if (input.equals("special")){
            totalPrice -= totalPrice * 10 / 100;

            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",price);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }else {


            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n",price,taxes,totalPrice );
        }

    }
}

package com.company;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberPeople = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String day = sc.nextLine();
        double price = 0;


        if (typeOfGroup.equals("Students")){
              if (day.equals("Friday")){
                 price = 8.45 * numberPeople;
              }else if (day.equals("Saturday")){
                  price = 9.80 * numberPeople;
              }
              else if (day.equals("Sunday")){
                  price = 10.46 * numberPeople;
              }
              if (numberPeople >= 30){
                  price -= price * 15 / 100;
              }
        }
        else if (typeOfGroup.equals("Business")){
            if (day.equals("Friday")){
                price = 10.90 * numberPeople;
            }else if (day.equals("Saturday")){
                price = 15.60 * numberPeople;
            }
            else if (day.equals("Sunday")){
                price = 16 * numberPeople;
            }
            if (numberPeople >= 100){
                price -= numberPeople / 10;
            }
        }
        else if (typeOfGroup.equals("Regular")){
            if (day.equals("Friday")){
                price = 15 * numberPeople;
            }else if (day.equals("Saturday")){
                price = 20 * numberPeople;
            }
            else if (day.equals("Sunday")){
                price = 22.50 * numberPeople;
            }
            if (numberPeople >= 10 && numberPeople <= 20){
                price -= price * 5 / 100;
            }
        }

        System.out.printf("Total price: %.02f", price);
    }
}

package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();
        String input = scanner.nextLine();


        while (!input.equalsIgnoreCase("End")) {
            String[] splitedInput = input.split(", ");
            String command = splitedInput[0];
            String carNum = splitedInput[1];

            if (command.equalsIgnoreCase("In")) {
                carNumbers.add(carNum);
            } else if (command.equalsIgnoreCase("Out")) {
                carNumbers.remove(carNum);
            }


            input = scanner.nextLine();


        }
       if (carNumbers.isEmpty()){
           System.out.println("Parking Lot is Empty");
       }else{

        for (String carNumber : carNumbers) {
            System.out.println(carNumber);

        }
       }
    }
}

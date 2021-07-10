package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShipStatus = Arrays.stream(scanner.nextLine().split("\\>"))
                .mapToInt(Integer::parseInt).toArray();
        int[] warShipStatus = Arrays.stream(scanner.nextLine().split("\\>"))
                .mapToInt(Integer::parseInt).toArray();

        int sectionMaxHealth = Integer.parseInt(scanner.nextLine());
        boolean stalemate = false;
        String input = scanner.nextLine();
        while (!"Retire".equals(input)) {
            String[] splitedInput = input.split("\\s+");
            String command = splitedInput[0];
            if (command.equals("Fire")) {
                int index = Integer.parseInt(splitedInput[1]);
                int damage = Integer.parseInt(splitedInput[2]);

                if (index >= 0 && index < warShipStatus.length) {
                    warShipStatus[index] -= damage;
                    if  (warShipStatus[index] <= 0){
                        System.out.printf("You won! The enemy ship has sunken.");
                        return;
                    }
                }
            }else if (command.equals("Defend")){
                int startIndex = Integer.parseInt(splitedInput[1]);
                int endIndex = Integer.parseInt(splitedInput[2]);
                int damage = Integer.parseInt(splitedInput[3]);

                if (startIndex >= 0 && startIndex < pirateShipStatus.length && endIndex >= 0 && endIndex < pirateShipStatus.length){
                    for (int i = startIndex; i <= endIndex  ; i++) {
                        pirateShipStatus[i] -= damage;
                        if (pirateShipStatus[i] <= 0){
                            System.out.printf("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }

                }else  {
                    stalemate = true;
                }
            }else if (command.equals("Repair")){
                int index = Integer.parseInt(splitedInput[1]);
                int health = Integer.parseInt(splitedInput[2]);

                if (index >=0 && index < pirateShipStatus.length){
                    if (pirateShipStatus[index] + health > sectionMaxHealth){
                        pirateShipStatus[index] = sectionMaxHealth;
                    }
                }else{
                   pirateShipStatus[index] += health;
                }

            }else if (command.equals("Status")){
             int counter = 0;
             double percentage = sectionMaxHealth * 20 / 100;
                for (int i = 0; i <pirateShipStatus.length ; i++) {
                    if (pirateShipStatus[i]<percentage){
                        counter++;
                    }
                }
                System.out.printf("%d sections need repair.\n", counter);
            }

            input = scanner.nextLine();
        }
        int sumOfPirateHealth =0;

        for (int shipStatus : pirateShipStatus) {
            sumOfPirateHealth += shipStatus;
        }
        int sumOfWarshipHealth = 0;

        for (int shipStatus : warShipStatus) {
            sumOfWarshipHealth += shipStatus;
        }
        System.out.printf("Pirate ship status: %d\n", sumOfPirateHealth);
        System.out.printf("Warship status: %d", sumOfWarshipHealth);
    }
}

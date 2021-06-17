package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();
        List<String> steal = new ArrayList<>();
        while (!"Yohoho!".equals(input)){
            String[] splitedInput = input.split("\\s+");
            String command = splitedInput[0];
            if (command.equals("Loot")){
                for (int i = 1; i <splitedInput.length ; i++) {
                    if (!items.contains(splitedInput[i])){
                        items.add(0, splitedInput[i]);
                    }
                }
                
            }else if (command.equals("Drop")){
                int index = Integer.parseInt(splitedInput[1]);
                if (index >= 0 && index < items.size() ){
                    items.add(items.size(), items.get(index));
                    items.remove(index);

                }else {

                }
            }else if (command.equals("Steal")){
                int numberOfStolenItems = Integer.parseInt(splitedInput[1]);
                if (numberOfStolenItems >= items.size()){
                    int counter = 0;
                    for (String item : items) {
                        counter++;
                        if (counter == items.size()){
                            System.out.println(item);
                        }else{
                            System.out.printf("%s, ", item);
                        }
                    }
                    System.out.println("Failed treasure hunt.");
                    return;
                }else{
                    int counter = items.size() - numberOfStolenItems;
                    for (int i = items.size()-numberOfStolenItems; i <= items.size()-1 ; i++) {
                      counter++;
                      if (items.size() == counter){
                          System.out.println(items.get(i));
                      }else{
                          System.out.printf("%s, ", items.get(i));
                      }
                    }
                }
                int counter = items.size()-1-numberOfStolenItems;
                for (int i = items.size()-1; i >= items.size()-numberOfStolenItems ; i--) {
                    if (counter != i){
                        items.remove(i);
                    }else {
                        break;
                    }
                }

            }else{
                break;
            }
            input = scanner.nextLine();
        }

        double numOfLetters = 0;
        for (String item : items) {
            numOfLetters += item.length();
        }
         double avgSum = numOfLetters / (items.size());
        System.out.printf("Average treasure gain: %.2f pirate credits.", avgSum);

    }
}

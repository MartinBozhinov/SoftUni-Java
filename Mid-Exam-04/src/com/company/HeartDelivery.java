package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

          List<Integer> neighbourhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
              int lastIndex = 0;
           String input  = scanner.nextLine();

          while (!input.equals("Love!")){
              String[] splitedInput = input.split("\\s+");
              String command = splitedInput[0];
               int index = Integer.parseInt(splitedInput[1]);
               lastIndex += index;

             if (lastIndex >= neighbourhood.size()){
                 lastIndex = 0;
             }
             if (index < neighbourhood.size() && index >= 0 ){
                if (lastIndex < neighbourhood.size()){
                   if (neighbourhood.get(lastIndex) == 0){
                       System.out.printf("Place %d already had Valentine's day.\n", lastIndex);
                   }else {
                       neighbourhood.set(lastIndex, neighbourhood.get(lastIndex) - 2);
                       if (neighbourhood.get(lastIndex) == 0){
                           System.out.printf("Place %d has Valentine's day.\n", lastIndex);
                       }
                   }
                }else {
                    lastIndex = 0;
                    if (neighbourhood.get(0) == 0){
                        System.out.printf("Place %d already had Valentine's day.\n", lastIndex);
                    }else {
                        neighbourhood.set(0, neighbourhood.get(0) - 2);
                        if (neighbourhood.get(lastIndex) == 0){
                            System.out.printf("Place %d has Valentine's day.\n", lastIndex);

                        }
                    }
                }
             }

              input = scanner.nextLine();
          }

        System.out.printf("Cupid's last position was %d.\n", lastIndex);
        int failedTimesCounter = 0;

        for (int houseHearts : neighbourhood) {
            if (houseHearts != 0) {
                failedTimesCounter++;
            }
        }
        if (failedTimesCounter != 0) {
            System.out.printf("Cupid has failed %d places.", failedTimesCounter);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}

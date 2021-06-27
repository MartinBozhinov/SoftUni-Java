package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"End".equals(input)){
            String[] splitedInput = input.split("\\s+");
            String command = splitedInput[0];
            if (command.equals("Shoot")){
              int index = Integer.parseInt(splitedInput[1]);
              int power = Integer.parseInt(splitedInput[2]);
              if (index >= 0 && index <= targets.size()){
                targets.set(index, targets.get(index) - power);
                if (targets.get(index) <= 0){
                    targets.remove(index);
                }
              }

            }else if (command.equals("Add")){
               int index = Integer.parseInt(splitedInput[1]);
               int value = Integer.parseInt(splitedInput[2]);

               if (index >= 0 && index <= targets.size()){
                   targets.add(index, value);
               }else{
                   System.out.println("Invalid placement!");
               }
            }else if (command.equals("Strike")){
            int index = Integer.parseInt(splitedInput[1]);
            int radius = Integer.parseInt(splitedInput[2]);

            if (index >= 0 && index <targets.size()){
                if (index - radius >= 0 && index + radius <targets.size()){
                    for (int i =index+radius; i >=index-radius ; i--) {
                     targets.remove(i);
                    }
                }else{
                    System.out.println("Strike missed!");
                }

            }

            }
            input = scanner.nextLine();
        }
            int counter = 0;
        for (Integer target : targets) {
            counter++;
            if (counter == targets.size()){
                System.out.print(target);

            }else{
                System.out.print(target + "|");
            }
        }
    }
}

package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("End")){
                break;

            }
            String[] splitedInput = input.split(" +");
            String command = splitedInput[0];

            if (command.equals("Add")){
                int number = Integer.parseInt(splitedInput[1]);
                numbers.add(number);

            }else if (command.equals("Insert")){
             int number = Integer.parseInt(splitedInput[1]);
             int index = Integer.parseInt(splitedInput[2]);
             if (index>= 0 && index < numbers.size()){
             numbers.add(index, number);
             }else  {
                 System.out.println("Invalid index");
             }



            }else if (command.equals("Remove")){
                int index = Integer.parseInt(splitedInput[1]);
                if (index>=0 && index < numbers.size()){
              numbers.remove(index);
                }else   {
                    System.out.println("Invalid index");
                }


            }else if (command.equals("Shift")){
               if (splitedInput[1].equals("left")){
                   int count = Integer.parseInt(splitedInput[2]);
                   for (int i = 0; i <count; i++) {
                       int firstNumber = numbers.get(0);
                       for (int j = 0; j < numbers.size()-1; j++) {
                           numbers.set(j, numbers.get(j+1));
                       }
                       numbers.set(numbers.size()-1, firstNumber);
                   }

               }
               else if (splitedInput[1].equals("right")){
                   int count = Integer.parseInt(splitedInput[2]);
                   for (int i = 0; i <count ; i++) {
                       int lastNumber = numbers.get(numbers.size()-1);
                       for (int j = numbers.size() -1; j > 0; j--) {
                           numbers.set(j, numbers.get(j-1));
                       }
                       numbers.set(0, lastNumber);
                   }

               }
            }

        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));
    }
}

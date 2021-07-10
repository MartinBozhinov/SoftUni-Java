package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] splitedInput = input.split(" ");
            String command = splitedInput[0];
            if(command.equals("Add")){
             int number = Integer.parseInt(splitedInput[1]);
             numbers.add(number);
            }else if (command.equals("Remove")){
             int number = Integer.parseInt(splitedInput[1]);
             numbers.remove(Integer.valueOf(number));
            }else if (command.equals("RemoveAt")){
             int index = Integer.parseInt(splitedInput[1]);
             numbers.remove(index);
            }else if (command.equals("Insert")){
             int number = Integer.parseInt(splitedInput[1]);
             int index = Integer.parseInt(splitedInput[2]);
             numbers.add(index, number);
            }

        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));

    }
}

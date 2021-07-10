package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] splitedInput = input.split(" ");

            String command = splitedInput[0];
            if (command.equals("Delete")){
                int element = Integer.parseInt(splitedInput[1]);
                for (int i = 0; i <numbers.size() ; i++) {
                numbers.removeIf(a -> a == element);
                }
            }else if (command.equals("Insert")){
              int element = Integer.parseInt(splitedInput[1]);
              int index = Integer.parseInt(splitedInput[2]);
                numbers.add(index, element);
            }
        }
        System.out.print(numbers.toString().replaceAll("\\[|,|\\]", ""));

    }
}

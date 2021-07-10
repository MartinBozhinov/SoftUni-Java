package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!"end".equals(input)){
            String[] splitedInput = input.split("\\s+");

            String command = splitedInput[0];
            if (command.equals("swap")){
                  int indexOne = Integer.parseInt(splitedInput[1]);
                  int indexTwo = Integer.parseInt(splitedInput[2]);
                  int currentIndex = array[indexOne];
                  array[indexOne] = array[indexTwo];
                  array[indexTwo] = currentIndex;
            }else if (command.equals("multiply")){
                int indexOne = Integer.parseInt(splitedInput[1]);
                int indexTwo = Integer.parseInt(splitedInput[2]);

                int multiply   = array[indexOne] * array[indexTwo];

                array[indexOne] = multiply;

            }else if (command.equals("decrease")){
                for (int i = 0; i <array.length ; i++) {
                    array[i]--;
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length-1){
                System.out.print(", ");
            }
        }

    }
}

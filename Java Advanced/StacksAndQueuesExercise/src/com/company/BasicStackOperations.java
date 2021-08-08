package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] splitedInput = scanner.nextLine().split("\\s+");

        int numberOfElementsToPush = Integer.parseInt(splitedInput[0]);
        int numbersToPop = Integer.parseInt(splitedInput[1]);
        int numberToCheck = Integer.parseInt(splitedInput[2]);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
          int smallest = Integer.MAX_VALUE;
          int cur = 0;
            String[] numbers = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numberOfElementsToPush; i++) {
        stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i <numbersToPop ; i++) {
            stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }else if (stack.contains(numberToCheck)){
            System.out.println("true");
        }else {

            for (Integer integer : stack) {
                if (integer < smallest){
                   smallest = integer;
                }
            }
            System.out.println(smallest);
        }


    }
}

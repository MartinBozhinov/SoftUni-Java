package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();

        String[] exl = input.split("\\s+");
        for (int i = exl.length -1 ; i >= 0; i--) {
         stack.push(exl[i]);
        }


        while (stack.size() > 1)  {
            Integer firstNum = Integer.parseInt(stack.pop());
             String op = stack.pop();
            Integer secondNum = Integer.parseInt(stack.pop());


            if ("+".equalsIgnoreCase(op)){
              stack.push(firstNum + secondNum + "");
            }else if ("-".equalsIgnoreCase(op)){
                stack.push(firstNum - secondNum + "");
            }
        }
        System.out.println(stack.peek());
    }
}

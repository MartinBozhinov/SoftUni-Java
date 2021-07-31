package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String input = scanner.nextLine();


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if ('(' == symbol){
                stack.push(i);
            }else if (')' == symbol){
              int startIndex = stack.pop();
              String contest = input.substring(startIndex, i+1);
                System.out.println(contest);
            }
        }
    }
}

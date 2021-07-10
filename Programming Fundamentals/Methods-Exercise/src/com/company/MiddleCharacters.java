package com.company;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChar(input);

    }

    private static void printMiddleChar(String input) {
        int inputLength = input.length();
        int middle = inputLength/2;
        if (inputLength % 2 == 0){
            char c = input.charAt(middle);
            char ch = input.charAt(middle-1);
            System.out.printf("%c%c",ch,c);
        }
        else if (inputLength%2==1){
            char c = input.charAt(middle);
            System.out.printf("%c",c);
        }
    }
}

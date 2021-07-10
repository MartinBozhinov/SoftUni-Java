package com.company;

import java.util.Scanner;

public class GreaterThanTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        switch (input){
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                getMax(a,b);
                System.out.println(getMax(a,b));
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                getMaxChar(firstChar,secondChar);
                System.out.println(getMaxChar(firstChar,secondChar));
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                getBiggerString(firstString,secondString);
                System.out.println(getBiggerString(firstString,secondString));
                break;

        }
    }

    private static String getBiggerString(String firstString, String secondString) {
         if (firstString.compareTo(secondString) >= 0){
             return firstString;
         }
         else   {
             return secondString;
         }
    }
    private static Character getMaxChar(char firstChar, char secondChar) {
        if (firstChar>secondChar){
            return firstChar;
        }
        return secondChar;
    }
    private static int getMax(int a, int b) {
        if (a>b){
            return a;
        }
        return b;
    }
}

package com.company;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number ; i++) {
            if (isDivisibleByEight(i) && oddDigit(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean oddDigit(int number) {
        String numberAsString=""+number;
        for (int j = 0; j <numberAsString.length() ; j++) {
            int currDigit = Character.getNumericValue(numberAsString.charAt(j));
            if (currDigit % 2 == 1){
                return true;
            }
        }
        return false;

    }

    private static boolean isDivisibleByEight(int number) {
        int sum = 0;
        String numberAsString = "" + number;
        for (int j = 0; j <numberAsString.length() ; j++) {
            int currDigit = Character.getNumericValue(numberAsString.charAt(j));
            sum += currDigit;
        }
        return sum % 8 == 0;
    }


}

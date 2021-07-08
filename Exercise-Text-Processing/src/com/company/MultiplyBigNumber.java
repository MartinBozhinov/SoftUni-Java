package com.company;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String reallyBigNumber = scanner.nextLine();

        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0){
            System.out.println(0);
            return;
        }
        while  (reallyBigNumber.charAt(0) == '0'){
            reallyBigNumber.substring(1);
        }
        int sum = 0;
        int reminder = 0;
         StringBuilder sb = new StringBuilder();
        for (int i = reallyBigNumber.length()-1; i >= 0; i--) {
            int num = Integer.parseInt(String.valueOf(reallyBigNumber.charAt(i)));
           int result = num * number + reminder;
           reminder = 0;
           if (result>9){
               reminder = result / 10 ;
               result %= 10;
           }
           sb.append(result);

        }
        if (reminder != 0){
            sb.append(reminder);
        }
        System.out.println(sb.reverse());
    }
}

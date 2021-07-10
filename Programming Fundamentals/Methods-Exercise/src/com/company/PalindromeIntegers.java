package com.company;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String numberAsString = scanner.nextLine();



         while(true)  {
             String afterConcat = "";
             if (numberAsString.equals("END")){
                break;
             }
             for (int i = numberAsString.length()-1; i >= 0 ; i--) {
                 afterConcat += numberAsString.charAt(i);
             }
             if (numberAsString.equals(afterConcat)){
                 System.out.println("true");
             }else  {
                 System.out.println("false");
             }


             numberAsString = scanner.nextLine();
        }

    }
}

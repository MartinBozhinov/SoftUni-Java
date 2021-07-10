package com.company;

import java.util.Scanner;

public class CharsInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        if (firstChar<secondChar){

         printCharactersInRange(firstChar,secondChar);
        }else {
            printCharactersInRange(secondChar,firstChar);
        }


    }

    private static void printCharactersInRange(char a, char b) {

        for (int i = ++a; i < b ; i++) {
            System.out.printf("%c ", i);
        }



    }
}

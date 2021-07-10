package com.company;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        String firstWord = words[0];
        String secondWord = words[1];

        int isSmaller = Math.min(firstWord.length(),secondWord.length()); // a
        int isBigger = Math.max(firstWord.length(),secondWord.length()); // words
           int sum = 0;

        for (int i = 0; i < isBigger; i++) {

            if (i < isSmaller){
                    sum += firstWord.charAt(i) * secondWord.charAt(i) ;
            }else if(isBigger == firstWord.length()){
                sum += firstWord.charAt(i);
            }else {
                sum += secondWord.charAt(i);
            }
        }
        System.out.println(sum);


    }


}

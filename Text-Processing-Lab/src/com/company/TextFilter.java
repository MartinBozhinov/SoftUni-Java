package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String star = getBannedWords(bannedWord.length());
            text = text.replace(bannedWord, star);
            

        }
        System.out.println(text);


    }

    private static String getBannedWords(int length) {
      List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add("*");
        }
        return String.join("", result);

    }
}

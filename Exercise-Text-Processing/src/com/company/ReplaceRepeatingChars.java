package com.company;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         String text = scanner.nextLine();
         StringBuilder sb = new StringBuilder();
         char base = text.charAt(0);
         sb.append(base);

        for (int i = 1; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current != base){
                sb.append(current);
                base = current;
            }

        }
        System.out.println(sb.toString());
    }
}

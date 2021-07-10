package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


      String text = scanner.nextLine();

        Map<Character, Integer> chars = new LinkedHashMap<>();


        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' '){
                char ch = text.charAt(i);
                if (chars.containsKey(ch)){
                    chars.put(ch, chars.get(ch)+1);
                }else  {
                    chars.put(ch, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(String.format("%c -> %d", entry.getKey(), entry.getValue()));

        }
    }
}

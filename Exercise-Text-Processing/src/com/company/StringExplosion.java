package com.company;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        int power= 0;
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (currChar == '>'){
                power += Integer.parseInt(String.valueOf(input.charAt(i+1)));
                 sb.append('>');
            }else if (power == 0){
             sb.append(currChar);
            }else {
                power--;
            }
        }
        System.out.println(sb);
    }
}

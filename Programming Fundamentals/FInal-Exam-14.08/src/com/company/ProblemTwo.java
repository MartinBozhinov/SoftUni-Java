package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^(.+)>(?<first>\\d+)\\|(?<second>[a-z]+)\\|(?<third>[A-Z]+)\\|(?<forth>[^<>]+)<\\1$";

        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String concat = "";
                String first = matcher.group("first");
                String second = matcher.group("second");
                String third = matcher.group("third");
                String forth = matcher.group("forth");

                concat = first + second + third + forth;
                System.out.printf("Password: %s%n", concat);
            }else {
                System.out.println("Try another password!");

            }
        }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] numbers = scanner.nextLine().split("\\|");
         List<String> result = new ArrayList<>();

        for (int i = numbers.length-1; i >=0 ; i--) {
           String[] temp = numbers[i].split("\\s+");
            for (String s : temp) {
                if (!"".equals(s)){
                    result.add(s);
                }
            }
        }
        System.out.println(String.join(" ", result));
    }
}

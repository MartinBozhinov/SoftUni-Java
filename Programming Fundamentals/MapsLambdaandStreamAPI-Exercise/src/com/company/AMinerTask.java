package com.company;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!"stop".equals(input)){
            Integer quantity = Integer.parseInt(scanner.nextLine());

            if (map.containsKey(input)){
                ;
                map.put(input, map.get(input) + quantity);
            }else{
                map.put(input, quantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        System.out.println(String.format("%s -> %s",entry.getKey(), entry.getValue() ));
        }

    }
}

package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String action = input[0];
            String name = input[1];
            if (action.equals("register")){
            String licensePlate = input[2];
                if (map.containsKey(name)){
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                }else{
                   map.put(name, licensePlate);
                    System.out.printf("%s registered %s successfully%n", name, licensePlate);
                }
            }else if  (action.equals("unregister")){
                if (!map.containsKey(name)){
                    System.out.printf("ERROR: user %s not found%n", name);
                }else {
                    System.out.printf("%s unregistered successfully%n", name);
                    map.remove(name);
                }
            }

        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(),entry.getValue());
        }
    }
}

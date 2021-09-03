package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {

    public static void main(String[] args) {
        Map<String, Integer> resources = new HashMap<String, Integer>();
        String resource = " ";
        Scanner scanner = new Scanner(System.in);
        while (!resource.equals("stop")) {

            resource = scanner.nextLine();
            if (!resource.equals("stop")) {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (!resources.containsKey(resource)) {
                    resources.put(resource, quantity);
                } else {
                    int val = resources.get(resource);
                    resources.put(resource, val += quantity);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }
}
package com.company;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] splitedInput = input.split(" -> ");
             String companyName = splitedInput[0];
             String employeeId = splitedInput[1];

             if (!map.containsKey(companyName)){
                 map.put(companyName,new ArrayList<>());
                  map.get(companyName).add(employeeId);

             }else{
                 if (map.get(companyName).contains(employeeId)){
                     map.get(companyName).remove(companyName);
                 }
                 map.get(companyName).add(employeeId);
             }
                    input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println("--" + s);
            }
        }
    }
}

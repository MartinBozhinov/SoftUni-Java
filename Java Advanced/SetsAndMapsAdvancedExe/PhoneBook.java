package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String nameAndPhone = scanner.nextLine();
            Map<String,String> phoneAndNameCount = new TreeMap<>();

            while (!nameAndPhone.equalsIgnoreCase("search")){

                String[] splitedInput = nameAndPhone.split("-");
                String name = splitedInput[0];
                String phone = splitedInput[1];
               phoneAndNameCount.putIfAbsent(name,phone);
               phoneAndNameCount.compute(name, (k,v) -> phone);

                nameAndPhone = scanner.nextLine();
            }

            String searchComm = scanner.nextLine();
            while (!searchComm.equalsIgnoreCase("stop")){

              if (phoneAndNameCount.containsKey(searchComm)){

                  System.out.println(String.format("%s -> %s", searchComm, phoneAndNameCount.get(searchComm)));
              }else{
                  System.out.println(String.format("Contact %s does not exist.", searchComm));
              }

                searchComm = scanner.nextLine();

            }

    }
}

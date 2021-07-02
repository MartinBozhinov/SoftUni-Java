package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         List<String> namesList = new ArrayList<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String names = scanner.nextLine();
            String[] namesArr = names.split(" ");
            if (namesArr[2].equals("going!")){
               if (namesList.contains(namesArr[0])){
                   System.out.printf("%s is already in the list!%n", namesArr[0]);
               }
               else {
                   namesList.add(namesArr[0]);
               }
            }else if (namesArr[2].equals("not")){
               if (namesList.contains(namesArr[0])){
                   namesList.remove(namesArr[0]);
               }
               else {
                   System.out.printf("%s is not in the list!%n", namesArr[0]);
               }
            }
        }
        for (String name : namesList) {
            System.out.println(name);
        }
    }
}

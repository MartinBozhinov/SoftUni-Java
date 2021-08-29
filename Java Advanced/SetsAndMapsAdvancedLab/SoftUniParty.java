package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> vipList = new TreeSet<>();
        Set<String> normalList = new TreeSet<>();


        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Party")){
            char ch = input.charAt(0);
            if (Character.isDigit(ch)){
                vipList.add(input);
            }else{
                normalList.add(input);
            }

            input = scanner.nextLine();
        }

        String inputTwo = scanner.nextLine();
           while (!inputTwo.equalsIgnoreCase("End")){

               if (vipList.contains(inputTwo) || normalList.contains(inputTwo)){
                  vipList.remove(inputTwo);
                  normalList.remove(inputTwo);
               }



               inputTwo = scanner.nextLine();

           }

           int totalSize = vipList.size() + normalList.size();

        System.out.println(totalSize);
        for (String s : vipList) {
            System.out.println(s);
        }
        for (String s : normalList) {
            System.out.println(s);
        }
    }


}

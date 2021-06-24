package com.company;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEficiency = Integer.parseInt(scanner.nextLine());

        int totalAnswered = firstEmployeeEficiency + secondEmployeeEficiency + thirdEmployeeEficiency;


        int studentsCount = Integer.parseInt(scanner.nextLine());
       int hourCounter = 0;

        while (studentsCount > 0){

            studentsCount -= totalAnswered;
             hourCounter++;

             if (hourCounter % 4 == 0){
                 hourCounter++;
             }

        }

        System.out.printf("Time needed: %dh.",hourCounter);
    }
}

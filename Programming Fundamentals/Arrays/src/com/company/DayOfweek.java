package com.company;

import java.util.Scanner;

public class DayOfweek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = new String[] { " ", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"

        };


        int n = Integer.parseInt(scanner.nextLine());

        if (n <= 7 && n >= 1){
            System.out.println(daysOfWeek[n]);
        }else  {
            System.out.println("Invalid day!");
        }
    }
}

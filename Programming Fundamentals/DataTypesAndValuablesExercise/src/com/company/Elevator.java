package com.company;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        int elevatorCapcity = Integer.parseInt(scanner.nextLine());

        int elevatorCourses = (int)Math.ceil((double)peopleCount/ elevatorCapcity);
        System.out.println(elevatorCourses);
    }
}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());




        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] <= 4){
                if (wagons[i]>=4){
                    break;
                }
                if (waitingPeople == 0){
                    break;
                }
                wagons[i]++;
                waitingPeople--;
            }
        }
        if (waitingPeople==0){
            System.out.println("The lift has empty spots!");
            for (int i = 0; i <wagons.length ; i++) {
                System.out.print(wagons[i] + " ");
            }
        }else if(waitingPeople != 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n",waitingPeople);
            for (int i = 0; i <wagons.length ; i++) {
                System.out.print(wagons[i] + " ");
            }
        }else{
            for (int i = 0; i <wagons.length ; i++) {
                System.out.print(wagons[i] + " ");
            }
        }

    }
}

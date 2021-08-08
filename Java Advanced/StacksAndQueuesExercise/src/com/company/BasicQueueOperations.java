package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] operations = scanner.nextLine().split("\\s+");

        int numberToQueue = Integer.parseInt(operations[0]);
        int numberToDeQueue = Integer.parseInt(operations[1]);
        int ifExisting = Integer.parseInt(operations[2]);
         int smallest = Integer.MAX_VALUE;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

            String[] input = scanner.nextLine().split("\\s+");
        for (int i = 0; i < numberToQueue; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < numberToDeQueue; i++) {
            queue.poll();
        }
        if (queue.isEmpty()){
            System.out.println(0);
        }
        else if (queue.contains(ifExisting)){
            System.out.println("true");
        }else{
            for (Integer integer : queue) {
                if (integer < smallest){
                    smallest = integer;
                }
            }
            System.out.println(smallest);
        }



    }
}

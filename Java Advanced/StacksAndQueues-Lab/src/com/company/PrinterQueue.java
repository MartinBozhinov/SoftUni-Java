package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileNames = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while  (!fileNames.equalsIgnoreCase("print")){

            if (!fileNames.equalsIgnoreCase("cancel")){
               queue.offer(fileNames);

            }else{
                if (queue.size() >= 1){
                    System.out.println("Canceled " + queue.poll());
                }else{
                    System.out.println("Printer is on standby");
                }
            }
            fileNames = scanner.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.pollFirst());
        }
    }
}

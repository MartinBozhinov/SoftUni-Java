package com.company;

import java.util.Scanner;

public class FirstProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String message = scanner.nextLine();


        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Finish")){
         String[] splitedInput = input.split("\\s+");
         String command = splitedInput[0];

         if  (command.equalsIgnoreCase("Replace")){
             String oldChar = splitedInput[1];
             String newChar = splitedInput[2];
             message = message.replace(oldChar,newChar);
             System.out.println(message);
         }else if (command.equalsIgnoreCase("Cut")){

             int startIndex = Integer.parseInt(splitedInput[1]);
             int endIndex = Integer.parseInt(splitedInput[2]);

             if (startIndex < 0 || startIndex > message.length() || endIndex < 0 || endIndex > message.length()){
                 System.out.println("Invalid indices!");
             }else {
                 StringBuilder sb = new StringBuilder();
                 sb.append(message);
                 sb.replace(startIndex,endIndex+1, "");
                 message = sb.toString();
                 sb.setLength(0);
                 System.out.println(message);

             }
         }else if (command.equalsIgnoreCase("Make")){
             String caseSense = splitedInput[1];
              if (caseSense.equalsIgnoreCase("Upper")){
                  message =  message.toUpperCase();
              }else if (caseSense.equalsIgnoreCase("Lower")){
                  message = message.toLowerCase();
              }
             System.out.println(message);
         }else if (command.equalsIgnoreCase("Check")){
           String str = splitedInput[1];

           if (message.contains(str)){
               System.out.printf("Message contains %s%n", str);
           }else {
               System.out.printf("Message doesn't contain %s%n", str);
           }
         }else if (command.equalsIgnoreCase("Sum")){
            int startIndex = Integer.parseInt(splitedInput[1]);
            int endIndex = Integer.parseInt(splitedInput[2]);

            if (startIndex<0 || startIndex>message.length() || endIndex <0 || endIndex>message.length()){
                System.out.println("Invalid indices!");
            }else {
                StringBuilder sb = new StringBuilder();
                String str = "";
                sb.append(message);
                int sum = 0;
                str = sb.substring(startIndex,endIndex+1);
                for (int i = 0; i <str.length() ; i++) {
                    char ch = str.charAt(i);
                    sum += ch;
                }
                System.out.println(sum);
            }
         }


            input = scanner.nextLine();
        }
    }
}

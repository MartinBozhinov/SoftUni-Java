package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulatiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] splitedInput = input.split("\\s+");
            String command = splitedInput[0];

            if (command.equals("exchange")){
                int index = Integer.parseInt(splitedInput[1]);
                if (index<0 && index> array.length){
                    System.out.println("Invalid index");
                }else  {
                    getNewArray(array,index);
                }
            }else if (command.equals("max")){
                if (splitedInput[1].equals("even")){
                    findMaxEven(array);
                }else if (splitedInput[1].equals("odd")){
                    findMaxOdd(array);
                }
            }else if (command.equals("min")){
               if (splitedInput[1].equals("even")){
                 findMinEven(array);
               }else if (splitedInput[1].equals("odd")){
                   findMinOdd(array);
               }
            }else if (command.equals("first")){
                int count = Integer.parseInt(splitedInput[1]);
              if (splitedInput[2].equals("even")){
                  findFirstCountEven(array,count);
              }else if (splitedInput[2].equals("odd")){
                  // findFirstCountOdd(array,count);
              }
            }else if (command.equals("last")){
                int count = Integer.parseInt(splitedInput[1]);
                if (splitedInput[2].equals("even")){
                    //findLastCountEven(array,count);
                }else if (splitedInput[2].equals("odd")){
                    // findLastCountOdd(array,count);
                }
            }
        }

    }

    private static void findFirstCountEven(int[] array, int count) {
        

    }

    private static void findMinOdd(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 != 0 && max >= array[i]){
                max = array[i];
                index = i;
            }
        }
        if (index == -1){
            System.out.println("No matches");
        }
        System.out.println(index);
    }

    private static void findMinEven(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 == 0 && max >= array[i]){
                max = array[i];
                index = i;
            }
        }
        if (index == -1){
            System.out.println("No matches");
        }
        System.out.println(index);
    }

    private static void findMaxOdd(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 != 0 && min >= array[i]){
                min = array[i];
                index = i;
            }
        }
        if (index == -1){
            System.out.println("No matches");
        }
        System.out.println(index);

    }

    private static void findMaxEven(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i <array.length ; i++) {
            if (array[i] % 2 == 0 && min >= array[i]){
                min = array[i];
                index = i;
            }
        }
        if (index == -1){
            System.out.println("No matches");
        }
             System.out.println(index);
    }

    private static void getNewArray(int[] array, int index) {
        int[] temp = new int[array.length];
        temp = copyArray(array);
        int count = 0;
        for (int i = index+1; i <temp.length ; i++) {
            array[count] = temp[i];
            count++;
        }
        for (int i = 0; i <= index ; i++) {
            array[count] = temp[i];
            count++;
        }
      }
    private static int[] copyArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arrOne = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] arrTwo = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstArrSum = 0;
        int index = 0;


        for (int i = 0; i <arrOne.length ; i++) {
            if (arrOne[i] == arrTwo[i]){
                firstArrSum += arrOne[i];
            }else if (arrOne[i] != arrTwo[i]){
                index = i;
                System.out.printf("Arrays are not identical. Found difference at %d index.",index);
                return;
            }
        }
        System.out.printf("Arrays are identical. Sum: %d",firstArrSum);

        
    }
}

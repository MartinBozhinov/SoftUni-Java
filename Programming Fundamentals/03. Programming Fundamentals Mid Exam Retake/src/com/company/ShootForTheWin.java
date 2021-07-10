package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
         int shotTargetsCount = 0;
          int targetsArrayNumberAtIndex = 0;
        while (!"End".equals(input)){
           int index = Integer.parseInt(input);
            if (index >= 0 && index < targetsArray.length){

                targetsArrayNumberAtIndex = targetsArray[index];
                shotTargetsCount++;
            for (int i = 0; i <targetsArray.length ; i++) {
                targetsArray[index] = -1;
                if (targetsArray[i] != -1){

              if (targetsArray[i] <= targetsArrayNumberAtIndex){
                  targetsArray[i] += targetsArrayNumberAtIndex;
              }else{
                  targetsArray[i] -= targetsArrayNumberAtIndex;
              }
                }else{
                    continue;
                }
               }

            }



            input = scanner.nextLine();
        }

        System.out.print("Shot targets: " + shotTargetsCount + " -> ");
        for (int i : targetsArray) {
            System.out.print(i + " ");
        }
    }
}

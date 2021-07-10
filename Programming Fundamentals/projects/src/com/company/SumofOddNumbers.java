package com.company;

import java.util.Scanner;

public class SumofOddNumbers {
    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //int sum =0;
       // int currentNumber = 1;
        //for (int i = 1; i <= n; i++) {
          //  sum += currentNumber;
            //System.out.println(currentNumber);
            //currentNumber+= 2;
        //}
        //System.out.println("Sum: " + sum);


                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int sum =0;
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 1){
                        System.out.println(i);
                        sum += i;
                    }
                }
                System.out.printf("Sum: %d%n", sum);

            }
        }





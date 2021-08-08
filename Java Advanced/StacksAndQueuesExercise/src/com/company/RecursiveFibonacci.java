package com.company;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static int[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
      memory = new int[n+1];
        int result = getFibb(n);
        System.out.println(result);
    }

    private static int getFibb(int n) {

        if (n < 2){
              return 1;
        }
        if (memory[n] != 0){
          return memory[n];
        }
        return memory[n] = getFibb(n-1) + getFibb(n -2);
    }
}

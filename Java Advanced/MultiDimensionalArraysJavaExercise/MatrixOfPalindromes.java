package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
          String[] input = scanner.nextLine().split("\\s+");


        char[][] matrix = new char[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

        char a = 'a';
        char b = 'a';

        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(a);
                System.out.print(b);
                System.out.print(a + " ");

                b++;
            }
            System.out.println();

            a++;
            b = a;

        }


    }
}

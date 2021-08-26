package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][cols];

        System.out.println(rows);
        System.out.println(cols);

        int totalSum = 0;

        for (int row = 0; row < matrix.length ; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < input.length; col++) {
                int number = Integer.parseInt(input[col]);
                matrix[row][col] = number;
                totalSum+=number;

            }
        }
        System.out.println(totalSum);
    }
}

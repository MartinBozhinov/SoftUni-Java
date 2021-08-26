package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row <matrix.length ; row++) {
            String[] inputData = scanner.nextLine().split(", ");
            for (int col = 0; col < inputData.length ; col++) {
                int number = Integer.parseInt(inputData[col]);
                matrix[row][col] = number;
            }
        }

        int biggestSum = Integer.MIN_VALUE;
        int biggestSumRow1 = -1;
        int biggestSumCols2 = -1;
        int biggestSumRow2 = -1;
        int biggestSumCols1 = -1;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col <matrix[row].length -1  ; col++) {
             int currSum = matrix[row][col] + matrix[row+1][col] + matrix[row][col+1] + matrix[row+1][col+1];
             if (currSum > biggestSum){
                 biggestSum = currSum;
                 biggestSumRow1 = matrix[row][col];
                 biggestSumRow2 = matrix[row+1][col];
                 biggestSumCols1 = matrix[row+1][col+1];
                 biggestSumCols2 = matrix[row][col+1];
             }

            }
        }
        System.out.println(biggestSumRow1 + " " + biggestSumCols2);
        System.out.println(biggestSumRow2 + " " + biggestSumCols1);
        System.out.println(biggestSum);
    }
}

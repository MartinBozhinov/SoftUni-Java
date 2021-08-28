package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int row = dim[0];
        int col = dim[1];

        int[][] matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < inputData.length; cols++) {
                int number = Integer.parseInt(inputData[cols]);
                matrix[rows][cols] = number;
            }

        }
          int maxSum = -1;
         int rowIndex = -1;
         int colIndex = -1;

        for (int rows = 1; rows <row - 1  ; rows++) {
            for (int cols = 1; cols <col-1 ; cols++) {
                int currentSum = getMatrixSum(matrix,rows,cols);
                if (currentSum > maxSum){
                   maxSum = currentSum;
                   rowIndex = rows;
                   colIndex = cols;
                }


            }
        }
        System.out.println("Sum = "+ maxSum);
        printMatrixByGivenCell(matrix,rowIndex,colIndex);

    }

    private static void printMatrixByGivenCell(int[][] matrix, int rowIndex, int colIndex) {

        int beginRow = rowIndex-1;
        int beginCol = colIndex-1;

        for (int i = beginRow; i < beginRow + 3 ; i++) {
            for (int j = beginCol; j <beginCol+3 ; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    private static int getMatrixSum(int[][] matrix, int row, int col) {

        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row+1][col];
        sum += matrix[row-1] [col];
        sum += matrix[row][col+1];
        sum+= matrix[row][col-1];
        sum += matrix[row-1][col-1];
        sum+= matrix[row-1][col+1];
        sum+= matrix[row+1][col-1];
        sum+= matrix[row+1][col+1];

        return sum;

    }
}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstMatrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] firstMatrix = new int[firstMatrixSize[0]][firstMatrixSize[1]];

        for (int row = 0; row < firstMatrix.length; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            firstMatrix[row] = new int[inputData.length];
            for (int col = 0; col <inputData.length ; col++) {
                int number = Integer.parseInt(inputData[col]);
                firstMatrix[row][col] = number;
            }

        }
        int[] secondMatrixSize =  Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] secondMatrix = new int[secondMatrixSize[0]][secondMatrixSize[1]];
        for (int row = 0; row <secondMatrix.length ; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            secondMatrix[row] = new int[inputData.length];
            for (int col = 0; col <inputData.length ; col++) {
                int number = Integer.parseInt(inputData[col]);
                secondMatrix[row][col] = number;
            }
        }
        if (firstMatrixSize[0] != secondMatrixSize[0]){
            System.out.println("not equal");
            return;
        }
         boolean areEqual = true;
        for (int row = 0; row < firstMatrix.length; row++) {
            boolean areNotEqual = firstMatrix[row].length != secondMatrix[row].length;
            if (areNotEqual){
                System.out.println("not equal");
                return;
            }
             for (int col = 0; col <firstMatrix[row].length ; col++) {
                int firstValue = firstMatrix[row][col];
                int secondValie = secondMatrix[row][col];


                if (firstValue != secondValie){
                    System.out.println("not equal");
                }
            }

        }
        System.out.println("equal");




    }
}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        for (int rows = 0; rows < matrix.length; rows++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < inputData.length; cols++) {
                 int number = Integer.parseInt(inputData[cols]);
                 matrix[rows][cols] = number;
            }
        }
        int searchNumber = Integer.parseInt(scanner.nextLine());
       boolean isFOund = false;
        for (int row = 0; row < matrix.length; row++) {
            int[] ints = matrix[row];
            for (int cols = 0; cols < ints.length; cols++) {
                int value = ints[cols];
                if (value == searchNumber){
                    System.out.println(row + " " + cols);
                    isFOund = true;
                }

            }
        }
        if (!isFOund){
            System.out.println("not found");
        }


    }
}

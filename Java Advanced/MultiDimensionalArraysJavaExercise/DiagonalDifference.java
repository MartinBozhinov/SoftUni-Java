package com.company;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dim][dim];

        for (int rows = 0; rows <matrix.length ; rows++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int cols = 0; cols <matrix[rows].length ; cols++) {
            int number = Integer.parseInt(input[cols]);
                   matrix[rows][cols] = number;
            }
        }

        int firstSum = findFirstDiagonalSum(matrix, dim);
        int secondSum = findSecondSum(matrix,dim);

        System.out.println(Math.abs(firstSum-secondSum));

    }

    private static int findSecondSum(int[][] matrix, int dim) {
        int secondarySum = 0;
        for (int row = dim-1; row >= 0 ; row--) {
            for (int col = 0; col < dim ; col++) {
                  secondarySum += matrix[row][col];
                  row--;

            }
        }
        return secondarySum;

    }

    private static int findFirstDiagonalSum(int[][] matrix, int dim) {

        int sum = 0;

        for (int row = 0; row <dim ; row++) {
            for (int col = 0; col <dim ; col++) {
                sum +=  matrix[row][col];
             row++;

            }
        }
        return sum;
    }
}

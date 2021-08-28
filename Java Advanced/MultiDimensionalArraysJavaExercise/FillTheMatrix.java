package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);

        int[][] matrix = new int[size][size];
        if (input[1].equalsIgnoreCase("A")){
            matrix = createMatrixPatternA(matrix,size);
        }else if (input[1].equalsIgnoreCase("B")) {
            matrix = createMatrixPatternB(matrix,size);

        }

        printMatrix(matrix);
    }

    private static int[][] createMatrixPatternB(int[][] matrix, int size) {
        int number = 1;

        for (int col = 0; col <size ; col++) {
                if (col % 2 != 0){
                    for (int row = size-1; row >= 0 ; row--) {
                          matrix[row][col] = number;
                          number++;
                    }

                }else {
                    for (int r = 0; r <size ; r++) {
                        matrix[r][col] = number;
                        number++;
                    }
                }
        }
        return matrix;

    }

    private static void printMatrix(int[][] matrix) {

        for (int r = 0; r <matrix.length ; r++) {
            for (int c = 0; c <matrix[r].length ; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrixPatternA(int[][] matrix, int size) {

      int number = 1;
        for (int col = 0; col <size ; col++) {
            for (int row = 0; row <size ; row++) {
                   matrix[row][col] = number;
                   number++;

            }
        }
        return matrix;


    }
}

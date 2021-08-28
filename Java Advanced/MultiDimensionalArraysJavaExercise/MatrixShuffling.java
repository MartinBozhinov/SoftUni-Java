package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        String[][] matrix = new String[dim[0]][dim[1]];

        for (int row = 0; row < dim[0]; row++) {
           matrix[row] = scanner.nextLine().split("\\s+");

        }

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] splitedInput = input.split("\\s+");
            if (!splitedInput[0].equalsIgnoreCase("swap")) {
                System.out.println("Invalid input!");

            } else {
                if (splitedInput.length > 5) {
                    System.out.println("Invalid input!");
                    continue;
                }
                int row1Index = Integer.parseInt(splitedInput[1]);
                int col1Index = Integer.parseInt(splitedInput[2]);
                int row2Index = Integer.parseInt(splitedInput[3]);
                int col2Index = Integer.parseInt(splitedInput[4]);
                if (row1Index < 0 || row1Index > matrix.length - 1 || row2Index < 0 || row2Index > matrix.length - 1 || col1Index < 0 || col1Index > matrix.length || col2Index < 0 || col2Index > matrix.length) {
                    System.out.println("Invalid unput!");
                } else {
                    matrix = swapElementsInMatrix(matrix, row1Index, row2Index, col1Index, col2Index);
                    printMatrix(matrix);
                }


            }


            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static String[][] swapElementsInMatrix(String[][] matrix, int row1Index, int row2Index, int col1Index, int col2Index) {
        String elementToRemove = "";
        String elementToPut = "";
        elementToRemove = matrix[row1Index][col1Index];
        elementToPut = matrix[row2Index][col2Index];
        matrix[row1Index][col1Index] = elementToPut;
        matrix[row2Index][col2Index] = elementToRemove;
        return matrix;

    }
}



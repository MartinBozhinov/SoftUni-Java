package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dim][dim];

        for (int row = 0; row < matrix.length; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < inputData.length; col++) {
                int number = Integer.parseInt(inputData[col]);
                matrix[row][col] = number;

            }

        }

        List<String> firstDiagonal = new ArrayList<>();
        List<String> secondDiagonal = new ArrayList<>();
        int diagonalPosition = 0;
        int secondRowCounter = dim-1;

        for (int row = 0; row < matrix.length; row++) {

            firstDiagonal.add(matrix[row][diagonalPosition]+"");
            secondDiagonal.add(matrix[secondRowCounter][diagonalPosition]+"");
            diagonalPosition ++ ;
            secondRowCounter --;

        }
        System.out.println(String.join(" ", firstDiagonal));
        System.out.println(String.join(" ", secondDiagonal));

    }
}

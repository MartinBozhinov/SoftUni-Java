package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotattion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();

        List<String> input = new ArrayList<>();

        int counter = getInputAndCounter(scanner,command,input);

        String rotationCommand = input.get(0);
        int degrees = getDegrees(rotationCommand);

        input.remove(0);
        int length = getMatrixLength(input);

        char[][] matrix = getMatrix(input,counter,length);
        if (degrees == 90){
            oneRotation(input,length,matrix);
        }else if (degrees == 0){
            print(input,length, matrix);
        }else if (degrees == 180){
          twoRotations(input,length,matrix);
        }


    }

    private static void twoRotations(List<String> input, int length, char[][] matrix) {


    }

    private static void oneRotation(List<String> input, int length, char[][] matrix) {
        char[][] newMatrix = new char[length][input.size()];

        int i = 0;
        for (int c =matrix.length-1 ; c >= 0  ; c--) {
            int j = 0;
            for (int r = 0; r <matrix[i].length ; r++) {
                newMatrix[c][j] = matrix[i][j];
                j++;
            }
            i++;
        }
           print(input,length,newMatrix);
    }

    private static void print(List<String> input, int length, char[][] newMatrix) {
        for (int r = 0; r <newMatrix.length;  r++) {
            for (int c = 0; c <newMatrix[r].length ; c++) {

                if (newMatrix[r][c] == 0){

                    newMatrix[r][c] = ' ';
                }
                System.out.println(newMatrix[r][c]);

            }
            System.out.println();

        }

    }

    private static char[][] getMatrix(List<String> input, int counter, int length) {

        char[][] matrix = new char[counter][length];
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = input.get(r).toCharArray();
            matrix[r] = arr;

        }
        return  matrix;
    }

    private static int getMatrixLength(List<String> input) {
        int max = Integer.MIN_VALUE;
        for (String s : input) {
            if(s.length() >= max)
            {
                max = s.length();

            }
        }
        return max;

    }

    private static int getDegrees(String rotationCommand) {
        String regex = "([A-Za-z]+)(\\()([0-9]+)(\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotationCommand);
        boolean matches = matcher.matches();
        int degrees = Integer.parseInt(matcher.group(3));

        while (degrees >= 360){
           degrees = degrees % 360;

        }
        return  degrees;

    }

    private static int getInputAndCounter(Scanner scanner, String command, List<String> input) {
        int counter = 0;
        while (!command.equalsIgnoreCase("END")){
             input.add(command);
             command = scanner.nextLine();
             counter++;
        }
        return  counter - 1;

    }
}

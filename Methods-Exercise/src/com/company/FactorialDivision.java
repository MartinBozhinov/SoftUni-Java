package com.company;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double firstNum = Double.parseDouble(scanner.nextLine()) ;
        double secondNum =Double.parseDouble(scanner.nextLine());


        firstNumFactiorial(firstNum);
        secondNumFactorial(secondNum);
        dividedResult(firstNum,secondNum);

    }

    private static void dividedResult(double firstNum, double secondNum) {
          double result = 0;
       result =  firstNumFactiorial(firstNum) / secondNumFactorial(secondNum);
        System.out.printf("%.2f\n", result);

    }

    private static double secondNumFactorial(double secondNum) {
        double factiorial = 1;
        for (double i = secondNum; i > 1 ; i--) {
            factiorial *= i;
        }
        return factiorial;
    }

    private static double firstNumFactiorial(double firstNum) {

        double factiorial = 1;
        for (double i = firstNum; i > 1 ; i--) {
            factiorial *= i;
        }
        return factiorial;

    }
}

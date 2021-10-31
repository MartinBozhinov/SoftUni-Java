package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(reader.readLine());
         String space = " ";
        for (int i = 1; i <= n ; i++) {
            printCurrentRow(n, i);
        }

        for (int i = n-1; i >0 ; i--) {
            printCurrentRow(n, i);

        }
    }

    private static void printCurrentRow(int n, int i) {
        System.out.print(printSpace(" ", n - i));
        System.out.print(printSpace("* ", i));
        System.out.println();
    }

    public static String printSpace(String str, int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- > 0){
            builder.append(str);

        }
        return builder.toString();
    }
}

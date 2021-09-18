package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) {


        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        List<Long> finalSum = new LinkedList<>();
        long finallSum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn))) {
         String input;
             long sum = 0;
         while ((input = reader.readLine()) != null){

             for (int i = 0; i <input.length() ; i++) {
                 sum += input.charAt(i);
             }

         }
         finalSum.add(sum);
         finallSum = sum;


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(finallSum);
    }
}

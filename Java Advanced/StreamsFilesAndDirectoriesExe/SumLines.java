package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SumLines {
    public static void main(String[] args) {


        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";
         List<Integer> sum = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn))){

            String line = "";
            while ((line = bfr.readLine()) != null){
            int currSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    currSum+=line.charAt(i);
                }
                sum.add(currSum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer integer : sum) {
            System.out.println(integer);
        }
    }
}

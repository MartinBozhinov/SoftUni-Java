package com.company;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/inputLineNumbers.txt";
        String pathOut = userDir + "/res/output.txt";
         int counter = 1;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut))){

            while ((line = reader.readLine()) != null){
                 writer.write(String.format("%d. %s%n", counter,line));
                 counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

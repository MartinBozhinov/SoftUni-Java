package com.company;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {


        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";

        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))){

            String line = "";
             int pos = 1;
             while ((line = bfr.readLine()) != null){
                 if (pos % 3 == 0){
                     bfw.write(line);
                     bfw.newLine();
                 }
                 pos++;
             }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

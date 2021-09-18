package com.company;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut))) {
           String line;
           while ((line = reader.readLine()) != null){
               for (int i = 0; i < line.length(); i++) {
                   char ch = line.charAt(i);
                   if (Character.isLetter(line.charAt(i))){

                       char charr = Character.toUpperCase(ch);
                       writer.write(charr);


                   }else if  (Character.isDigit(line.charAt(i))){
                       writer.write(line.charAt(i));
                   }else if  (line.charAt(i) == 32 || line.charAt(i) == 10){
                       writer.write(" ");
                   }else if (line.charAt(i) == ',' || line.charAt(i) == '.' || line.charAt(i) == '?' || line.charAt(i) == '!'
                           || line.charAt(i) == '-' || line.charAt(i) == '\''){
                       writer.write(line.charAt(i));

                   }
               }
               writer.newLine();

           }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

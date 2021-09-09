package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userDir = System.getProperty("user.dir");

        String path =userDir + "/res/input.txt";

        try (FileInputStream fis = new FileInputStream(path)){
               int oneByte = fis.read();
               while (oneByte >= 0){
                   String res = Integer.toBinaryString(oneByte);
                   System.out.print(res + " ");
                   oneByte = fis.read();

               }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

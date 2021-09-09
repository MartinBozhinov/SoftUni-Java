package com.company;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File f = new File("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = f.listFiles();

        for (File file : files) {
            if (!file.isDirectory()){
                System.out.println(String.format("%s: %d", file.getName(),file.length()));
            }
        }
    }
}

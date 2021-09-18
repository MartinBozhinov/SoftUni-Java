package com.company;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {


        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File[] file = new File(path).listFiles();

        int sum = 0;
        for (File file1 : file) {
            sum += file1.length();
        }
        System.out.println(sum);
    }
}

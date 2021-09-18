package com.company;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";
         int vowelsCount = 0;
         int consonantsCount = 0;
         int punctuationCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut))) {

            String line;
            while ((line = reader.readLine()) != null){

                for (int i = 0; i <line.length() ; i++) {
                    char ch = line.charAt(i);
                        if (ch == 'a' || ch == 'o' || ch == 'u' || ch == 'e' || ch == 'i'){
                            if (Character.isLowerCase(ch)){
                                       vowelsCount++;
                            }
                        }else if (ch == '?' || ch == '!' || ch == '.' || ch == ','){


                               punctuationCount++;

                        }else if  (ch == 32 || ch == 10){
                            continue;
                        }else if (!Character.isDigit(ch)){
                            consonantsCount++;
                        }

                }
            }
            System.out.println(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowelsCount,consonantsCount,punctuationCount));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

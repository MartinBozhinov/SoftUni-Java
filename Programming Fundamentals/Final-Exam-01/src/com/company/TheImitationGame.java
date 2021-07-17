package com.company;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String message = scanner.nextLine();


    String input = scanner.nextLine();

    while (!"Decode".equals(input)){
        String[] splitedInput = input.split("\\|");

        String command = splitedInput[0];
        if (command.equals("Move")){
            int numberOfLettersToMove = Integer.parseInt(splitedInput[1]);
          StringBuilder move = new StringBuilder();
          String substring = message.substring(0,numberOfLettersToMove);
          move.append(message);
          move.replace(0,numberOfLettersToMove,"");
          move.append(substring);
          message = move.toString();
          move.setLength(0);
        }else if(command.equals("Insert")){
            int index = Integer.parseInt(splitedInput[1]);
            String letter = splitedInput[2];
            StringBuilder insert = new StringBuilder();
            insert.append(message);
            insert.insert(index,letter);
            message=insert.toString();
            insert.setLength(0);
        }else if(command.equals("ChangeAll")){
            String oldWord = splitedInput[1];
            String newWord = splitedInput[2];
            message = message.replace(oldWord,newWord);
        }
        input = scanner.nextLine();

    }


        System.out.printf("The decrypted message is: %s", message);

    }
}

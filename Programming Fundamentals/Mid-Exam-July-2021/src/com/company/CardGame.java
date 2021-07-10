package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> cards = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> newDeck = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Ready")){

            String[] splitedInput = input.split("\\s+");
            String command = splitedInput[0];

            switch (command) {
                case "Add": {
                    String cardName = splitedInput[1];
                    if (!cards.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {

                        newDeck.add(cardName);
                    }
                    break;
                }
                case "Insert": {
                    String cardName = splitedInput[1];
                    int index = Integer.parseInt(splitedInput[2]);
                    if (!cards.contains(cardName) || index < 0 || index >= cards.size()) {
                        System.out.println("Error!");

                    } else {
                        newDeck.add(index, cardName);
                    }
                    break;
                }
                case "Remove": {
                    String cardName = splitedInput[1];
                    if (newDeck.contains(cardName)) {
                        newDeck.remove(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                }
                case "Swap":
                    String cardOne = splitedInput[1];
                    String cardTwo = splitedInput[2];

                   Collections.swap(newDeck,newDeck.indexOf(cardOne),newDeck.indexOf(cardTwo));


                    break;
                case "Shuffle":
                    Collections.reverse(newDeck);
                    break;
            }


             input = scanner.nextLine();
        }
        for (String card : newDeck) {
            System.out.print(card + " ");


        }
    }
}

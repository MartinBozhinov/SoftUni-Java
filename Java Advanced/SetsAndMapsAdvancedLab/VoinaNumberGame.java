package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<Integer> firstPlayerCards = getPlayerCards(scanner.nextLine());

        Set<Integer> secondPlayerCards = getPlayerCards(scanner.nextLine());




        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty()){
                break;
            }
            if (secondPlayerCards.isEmpty()){
               break;
            }

          int firstCard = firstPlayerCards.iterator().next();
          int secondCard = secondPlayerCards.iterator().next();

          if (firstCard > secondCard){
              firstPlayerCards.add(firstCard);
              firstPlayerCards.add(secondCard);
          }else if (secondCard > firstCard){
              secondPlayerCards.add(secondCard);
              secondPlayerCards.add(firstCard);
          }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if (secondPlayerCards.size() > firstPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw");
        }
    }

     static LinkedHashSet<Integer> getPlayerCards(String nextLine) {

        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).forEach(result::add);

        return  result;
    }
}

package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        while (!(firstPlayerCards.size()==0 || secondPlayerCards.size() == 0)){
            int firstCard = firstPlayerCards.get(0);
            int secondPlayaCard = secondPlayerCards.get(0);
            if (firstCard > secondPlayaCard){
               firstPlayerCards.add(firstCard);
               firstPlayerCards.add(secondPlayaCard);
               firstPlayerCards.remove(0);
               secondPlayerCards.remove(Integer.valueOf(secondPlayaCard));

            }else if (secondPlayaCard>firstCard){
                secondPlayerCards.add(secondPlayaCard);
                secondPlayerCards.add(firstCard);
                secondPlayerCards.remove(0);
                firstPlayerCards.remove(Integer.valueOf(firstCard));

            }else if (firstCard==secondPlayaCard){
                firstPlayerCards.remove(Integer.valueOf(firstCard));
                secondPlayerCards.remove(Integer.valueOf(secondPlayaCard));
            }
        }
        if (firstPlayerCards.size()>0){

          int sum = winnerPlayer(firstPlayerCards);
            System.out.printf("First player wins! Sum: %d\n", sum);
        }else if (secondPlayerCards.size()>0){
            int sum = winnerPlayerTwo(secondPlayerCards);
            System.out.printf("Second player wins! Sum: %d\n", sum);

        }
    }

    private static int winnerPlayerTwo(List<Integer> secondPlayerCards) {
       int result = 0;
        for (Integer secondPlayerCard : secondPlayerCards) {
            result += secondPlayerCard;
        }

        return result;
    }

    private static int winnerPlayer(List<Integer> firstPlayerCards) {
        int result = 0;
        for (Integer firstPlayerCard : firstPlayerCards) {
            result += firstPlayerCard;
        }
        return result;
    }
}

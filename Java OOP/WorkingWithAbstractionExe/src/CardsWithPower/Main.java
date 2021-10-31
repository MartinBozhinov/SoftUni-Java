package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        int power = 0;
       int rankPower =  CardRank.valueOf(rank).getValue() + CardSuit.valueOf(suit).getValue();

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                rank,suit,rankPower));
    }
}

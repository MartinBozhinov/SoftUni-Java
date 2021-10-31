package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");


        CardSuit[] values = CardSuit.values();
        System.out.println(String.format("Card Suits:"));
        for (CardSuit value : values) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(),
                    value));
        }
    }
}

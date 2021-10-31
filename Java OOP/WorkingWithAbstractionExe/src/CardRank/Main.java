package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(String.format("Card Ranks:"));
        CardRank[] values = CardRank.values();

        for (CardRank value : values) {

            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(),value
                     ));
        }
    }
}

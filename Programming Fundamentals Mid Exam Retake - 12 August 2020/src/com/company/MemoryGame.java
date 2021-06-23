package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int movesCounter = 0;
        while (!"end".equals(input)) {
            movesCounter++;
            String[] splitedInput = input.split("\\s+");
            int firstIndex = Integer.parseInt(splitedInput[0]);
            int secondIndex = Integer.parseInt(splitedInput[1]);
            if (firstIndex < 0 || firstIndex >= elements.size() || secondIndex < 0 || secondIndex >= elements.size() || firstIndex == secondIndex) {
                int middleIndex = elements.size() / 2;
                elements.add(middleIndex, "-" + movesCounter + "a");
                elements.add(middleIndex, "-" + movesCounter + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                String indexValue = elements.get(firstIndex);
                if (firstIndex > secondIndex) {
                   elements.remove(firstIndex);
                   elements.remove(secondIndex);
                } else {
                    elements.remove(secondIndex);
                    elements.remove(firstIndex);
                }
                System.out.printf("Congrats! You have found matching elements - %s!\n", indexValue);
            } else if (!elements.get(firstIndex).equals(elements.get(secondIndex))) {
                System.out.println("Try again!");
            }
            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!", movesCounter);
                return;
            }
            input = scanner.nextLine();
        }
        System.out.println("Sorry you lose :(" );
        System.out.print(String.join(" ", elements));
    }
}




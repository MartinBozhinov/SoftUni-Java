package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            String regex = "([#||])(?<itemFirst>[A-Za-z]+\\s*[A-za-z]+)\\1(?<date>[0-9]+\\/[0-9]+\\/[0-9]+)\\1(?<calories>[0-9]+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> items = new ArrayList<>();
        int totalCalories = 0;
        int days = 0;
        while (matcher.find()){
            totalCalories += Integer.parseInt(matcher.group("calories"));

            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", matcher.group("itemFirst"), matcher.group("date"), Integer.parseInt(matcher.group("calories"))));

        }
        while (totalCalories>=2000){
            days++;
            totalCalories -= 2000;
        }
        System.out.printf("You have food to last you for: %d days!\n", days);

        for (String item : items) {

            System.out.println(item);
        }

    }
}

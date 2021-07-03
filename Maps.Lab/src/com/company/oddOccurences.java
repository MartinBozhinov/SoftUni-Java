package com.company;

import java.util.*;

public class oddOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordToLower = word.toLowerCase();
            if (counts.containsKey(wordToLower)){
                counts.put(wordToLower, counts.get(wordToLower)+1);
            }else   {
                counts.put(wordToLower, 1);
            }
        }
           List<String> wordsAsList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1){
                wordsAsList.add(entry.getKey());
            }
        }
        for (int i = 0; i < wordsAsList.size(); i++) {
            System.out.print(wordsAsList.get(i));
            if (i < wordsAsList.size() - 1){
                System.out.print(", ");
            }
        }



    }
}

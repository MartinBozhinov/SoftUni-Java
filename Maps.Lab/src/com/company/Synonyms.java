package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Synonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> counts = new LinkedHashMap<>();

             int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (counts.containsKey(key)){
               List<String> synonyms = counts.get(key);
                synonyms.add(synonym);
                counts.put(key, synonyms);
            }else   {
                ArrayList<String> word = new ArrayList<>();
                word.add(synonym);
                counts.put(key, word);
            }
        }
        for (Map.Entry<String, List<String>> entry : counts.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue().toString().replaceAll("\\[|\\]", ""));
        }


    }
}

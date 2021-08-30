package com.company;

import java.util.*;

public class CitiesByContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> countryCity = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String town = input[2];
            countryCity.putIfAbsent(continent, new LinkedHashMap<>());
            countryCity.get(continent).putIfAbsent(country, new LinkedList<>());
            countryCity.get(continent).get(country).add(town);

        }

        countryCity.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(e -> {
                System.out.print(" " + e.getKey() + " -> ");
                System.out.println(String.join(", ",e.getValue()));

            });
        });


    }
}


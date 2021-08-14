package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> personHealth = new TreeMap<>();
        Map<String, Integer> personEnergy = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Results")) {

            String[] splitedInput = input.split(":");
            String command = splitedInput[0];
            if (command.equalsIgnoreCase("Add")) {
                String personName = splitedInput[1];
                int health = Integer.parseInt(splitedInput[2]);
                int energy = Integer.parseInt(splitedInput[3]);

                if (!personHealth.containsKey(personName) && !personEnergy.containsKey(personName)) {
                    personHealth.put(personName, health);
                    personEnergy.put(personName, energy);
                } else {
                    personHealth.put(personName, personHealth.get(personName) + health);
                }

            } else if (command.equalsIgnoreCase("Attack")) {

                String attackerName = splitedInput[1];
                String defenderName = splitedInput[2];
                int damge = Integer.parseInt(splitedInput[3]);

                if (personHealth.containsKey(attackerName) && personHealth.containsKey(defenderName)) {
                    int currDefHealth = personHealth.get(defenderName);
                    int currAttackerEnergy = personEnergy.get(attackerName);
                    if (currDefHealth - damge <= 0) {
                        personHealth.remove(defenderName);
                        personEnergy.remove(defenderName);
                        System.out.printf("%s was disqualified!%n", defenderName);
                    } else {
                        personHealth.put(defenderName, personHealth.get(defenderName) - damge);
                    }
                    if (currAttackerEnergy - 1 <= 0) {
                        personEnergy.remove(attackerName);
                        personHealth.remove(attackerName);
                        System.out.printf("%s was disqualified!%n", attackerName);
                    } else {
                        personEnergy.put(attackerName, personEnergy.get(attackerName) - 1);
                    }
                }
            }else if (command.equalsIgnoreCase("Delete")){
              String username = splitedInput[1];
              if (username.equalsIgnoreCase("All")){
                 personEnergy.clear();
                 personHealth.clear();
              }
              if (personEnergy.containsKey(username) ){
                  personEnergy.remove(username);
                  personHealth.remove(username);
              }
            }
            input = scanner.nextLine();
        }

        System.out.printf("People count: %d%n", personHealth.size());
        personHealth.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue()
                .reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.printf("%s - %d - %d%n", entry.getKey(), entry.getValue(), personEnergy.get(entry.getKey())));
    }
}

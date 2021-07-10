package com.company;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);

        Map<String, Integer> junkMaterials = new LinkedHashMap<>();
        boolean isObtained = false;
        while (!isObtained){

            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i <input.length ; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1].toLowerCase();
                if (keyMaterials.containsKey(material)){
                   addToMap(keyMaterials, material, quantity);
                  isObtained = isObtained(keyMaterials, material);
                   if(isObtained){
                       break;
                   }
                }else{
                    addToMap(junkMaterials, material, quantity);
                }
            }
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((i1,i2) ->{
                    int result = i2.getValue().compareTo(i1.getValue());
                    if (result==0){
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                }).forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));



        junkMaterials.entrySet().stream().sorted((i1,i2) -> i1.getKey().compareTo(i2.getKey()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(),i.getValue()));
    }




    private static boolean isObtained(Map<String, Integer> map, String material) {
        if(map.get(material) >= 250){
            int newQuantity = map.get(material) - 250;
            map.put(material, newQuantity);
            switch (material) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
            }
            return true;
        }
        return false;
    }

    private static void addToMap(Map<String, Integer> map, String material, int quantity) {

        map.putIfAbsent(material, 0);
        int newQuantity = map.get(material) + quantity;
        map.put(material , newQuantity);

    }
}

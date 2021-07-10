package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] splitedInput = input.split(" ");
            if (splitedInput[0].equals("Add")){
                int people = Integer.parseInt(splitedInput[1]);
                train.add(people);
            }else{
                int people = Integer.parseInt(splitedInput[0]);
                for (int i = 0; i <train.size() ; i++) {
                    if(train.get(i) + people <= capacity){
                        train.set(i, train.get(i)+people);
                        break;
                    }
                }
            }

        }
        System.out.print(train.toString().replaceAll("\\[|,|\\]", ""));
    }
}

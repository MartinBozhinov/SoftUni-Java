package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int average = 0;


        for (int i = 0; i < numbers.size(); i++) {
            average += numbers.get(i);
        }
        average /= numbers.size();
        int greaterNums = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() ==1){
                System.out.println("No");
                break;
            }
           else if (numbers.get(i) > average) {
                result.add(numbers.get(i));
            }
        }
         Collections.sort(result);
        Collections.reverse(result);
       int count = 0;
        for (Integer integer : result) {
            System.out.print(integer + " ");
            count++;
            if (count == 5){
                break;
            }
        }
    }
}





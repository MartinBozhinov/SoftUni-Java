package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

    List<Integer> arrOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    List<Integer> arrTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
     List<Integer> resultList = new ArrayList<Integer>();


        int smaller = Math.min(arrOne.size(), arrTwo.size());

        for (int i = 0; i <smaller ; i++) {
            resultList.add(arrOne.get(i));
            resultList.add(arrTwo.get(i));
        }
         List<Integer> isBigger = new ArrayList<>();
        if (arrOne.size() > smaller){
            isBigger = arrOne;
        }
        else  {
            isBigger = arrTwo;
        }
        for (int i = smaller; i <isBigger.size() ; i++) {
            resultList.add(isBigger.get(i));
        }
        System.out.println(resultList.toString().replaceAll("\\[|,|\\]", ""));

    }
}

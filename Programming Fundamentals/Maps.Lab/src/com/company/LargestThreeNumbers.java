package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

          Arrays.stream(scanner.nextLine().split("\\s+"))
                  .map(Integer::parseInt)
                  .sorted((l,r) -> r.compareTo(l))
                  .limit(3)
                  .forEach(n -> System.out.print(n+ " "));





    }


}

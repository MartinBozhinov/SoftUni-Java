package com.company;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] nAndM = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

         int n = nAndM[0];
         int m = nAndM[1];
         Set<Integer>  firstSet = new LinkedHashSet<>();
         Set<Integer>  secondSet = new LinkedHashSet<>();

          while (n-- > 0 ){
               int number = scanner.nextInt();
               firstSet.add(number);
          }

          while (m-- > 0 ){
              int number = scanner.nextInt();
              secondSet.add(number);
          }

          firstSet.retainAll(secondSet);

          firstSet.forEach(e -> System.out.print(e + " "));
    }
}

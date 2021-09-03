package com.company;

import javax.swing.tree.TreeCellRenderer;
import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
         Set<String> set = new TreeSet<>();
        while (n-- > 0){
            String[] elements  = scanner.nextLine().split("\\s+");

            set.addAll(Arrays.asList(elements));
        }

        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}

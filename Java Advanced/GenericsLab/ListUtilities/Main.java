package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

           List<Integer> numbers = new ArrayList<>();

        Collections.addAll(numbers, 1,2,3,4,5,6,7,8);

        Integer minInteger = ListUtils.getMin(numbers);

        System.out.println(minInteger);

        Integer maxInteger = ListUtils.getMax(numbers);
        System.out.println(maxInteger);
    }
}

package GenericArrayCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] nums = ArrayCreator.create(Integer.class, 10, 10);
        System.out.println();
    }
}

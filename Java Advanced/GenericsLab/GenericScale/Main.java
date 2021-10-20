package GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Scale<String> strScale = new Scale<>("a","c");
        System.out.println(strScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(1,2);
        System.out.println(strScale.getHeavier());

    }
}

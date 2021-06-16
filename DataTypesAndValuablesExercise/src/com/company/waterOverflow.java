package com.company;
import java.util.Scanner;
class overFlow{
    public static void main(String[] args) {
        Scanner scanner= new Scanner( System.in);

        int n =Integer.parseInt(scanner.nextLine());
        int all = 255;
        int capacity=0;

        for (int i = 0; i < n; i++) {
            int litres = Integer.parseInt(scanner.nextLine());
            if (capacity + litres <= all){
                capacity+=litres;
            }else {
                System.out.println("Insufficient capacity!");
            }

        }

        System.out.println(capacity);
    }
}
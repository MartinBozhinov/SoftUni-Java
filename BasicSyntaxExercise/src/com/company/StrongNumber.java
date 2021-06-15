package com.company;
import java.util.Scanner;
public class StrongNumber {
    public static void main(String[] args) {






                Scanner scanner = new Scanner(System.in);

                int beg = Integer.parseInt(scanner.nextLine());
                String str = Integer.toString(beg);
                int sum_2 = 0;

                for (int i = 0; i < str.length(); i++ ) {
                    int sum_1 = 1;
                    char x = str.charAt(i);
                    int a = Character.getNumericValue(x);
                    for (int k = 1; k <= a; k++) sum_1*=k;
                    sum_2+= sum_1;
                }
                if (beg == sum_2) System.out.printf("yes");
                else System.out.printf("no");
            }
        }



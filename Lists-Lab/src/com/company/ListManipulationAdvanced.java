package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            String[] splitedInput = input.split(" ");

            String command = splitedInput[0];
            if (command.equals("Contains")) {
                int number = Integer.parseInt(splitedInput[1]);
                if (numbers.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (command.equals("Print")) {
                String type = splitedInput[1];
                if (type.equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 0) {
                            System.out.print(numbers.get(i) + " ");

                        }
                    }
                } else if (type.equals("odd")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 1) {
                            System.out.print(numbers.get(i) + " ");

                        }
                    }

                }
                System.out.println();
            } else if (command.equals("Get")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);
            } else if (command.equals("Filter")) {
                int number = Integer.parseInt(splitedInput[2]);
                if (splitedInput[1].equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (splitedInput[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (splitedInput[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > number) {
                            System.out.print(numbers.get(i) + " ");
                        }
                        System.out.println();
                    }
                } else if (splitedInput[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= number) {
                            System.out.print(numbers.get(i) + " ");
                        }

                    }
                    System.out.println();
                }
            }
        }
    }
}
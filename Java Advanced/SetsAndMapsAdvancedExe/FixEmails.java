package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equalsIgnoreCase("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.putIfAbsent(name, email);
            }
            name = scanner.nextLine();
        }

        emails.forEach((k,v) -> {
            System.out.println(String.format("%s -> %s", k,v));
        });
    }
}

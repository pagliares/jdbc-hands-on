package xyz.pagliares.jdbc.util;

import java.util.Scanner;

public class KeyboardInput {
    public static String readInputAsString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
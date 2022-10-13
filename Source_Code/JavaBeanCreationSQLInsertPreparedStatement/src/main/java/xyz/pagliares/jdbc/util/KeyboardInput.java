package xyz.pagliares.jdbc.util;

import java.util.Scanner;

public class KeyboardInput {
    public static String readInputAsString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static double getDoubleInput(String prompt) throws NumberFormatException {
        String input = readInputAsString(prompt);
        return Double.parseDouble(input);

    }

    public static int getIntegerInput(String prompt) throws NumberFormatException {
        String input = readInputAsString(prompt);
        return Integer.parseInt(input);
    }
}
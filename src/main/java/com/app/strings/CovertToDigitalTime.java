package com.app.strings;

import java.util.Scanner;

/**
 * @author t0k02w6 on 11/07/21
 * @project ds-algo-udemy
 */
public class CovertToDigitalTime {
    private static String convertToDigitalTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return hours + ":" + (String.valueOf(mins).length() == 1 ? ("0" + mins): mins);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutes = scanner.nextInt();

        System.out.println(convertToDigitalTime(minutes));

        scanner.close();
    }
}

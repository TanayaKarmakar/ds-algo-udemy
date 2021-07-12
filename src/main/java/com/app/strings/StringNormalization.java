package com.app.strings;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/07/21
 * @project ds-algo-udemy
 */
public class StringNormalization {
    private static String transform(String token) {
        char[] arr = token.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 65 && arr[i] <= 91) {
                arr[i] = (char)(arr[i] + 32);
            }
        }
        arr[0] = (char)(arr[0] - 32);
        return new String(arr);
    }

    private static String normalize(String str) {
        String[] strArr = str.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(String token: strArr) {
            sb.append(transform(token) + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String ans = normalize(str);

        System.out.println(ans);
        scanner.close();
    }
}

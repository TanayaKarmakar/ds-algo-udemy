package com.app.strings;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/07/21
 * @project ds-algo-udemy
 */
public class PalindromeBreak {
    private static String palindromeBreak(String str) {
        char[] strArr = str.toCharArray();
        if(strArr.length == 1) {
            int val = strArr[0] - 1;
            strArr[0] = (char)val;
            return new String(strArr);
        }
        int start = 0;
        int end = strArr.length - 1;
        char ch;
        char orig;
        int pos = -1;
        String prev = "";
        while(start < end) {
            if(strArr[start] == 'a') {
                orig = strArr[end];
                pos = end;
                int value = strArr[end] + 1;
                strArr[end] = (char) value;
            } else {
                orig = strArr[start];
                pos = start;
                int value = strArr[start] - 1;
                strArr[start] = (char) value;
            }
            String newStr = new String(strArr);
            if(!prev.equals("")) {
                int val = prev.compareTo(newStr);
                if(val > 0) {
                    prev = newStr;
                }
            } else {
                prev = newStr;
            }
            strArr[pos] = orig;
            start++;
            end--;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String ans = palindromeBreak(str);

        System.out.println(ans);

        scanner.close();
    }
}

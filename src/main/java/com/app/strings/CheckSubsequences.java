package com.app.strings;

import java.util.Scanner;

/**
 * @author t0k02w6 on 07/07/21
 * @project ds-algo-udemy
 */
public class CheckSubsequences {
    private static boolean isSubseq(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0;
        int j = 0;

        while(i < m) {
            if(j == n)
                break;
            if(s.charAt(i) == t.charAt(j))
                j++;
            i++;
        }
        return j == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();
        String target = scanner.nextLine();


        System.out.println(isSubseq(source, target));
        scanner.close();
    }
}

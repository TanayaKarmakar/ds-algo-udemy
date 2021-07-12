package com.app.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author t0k02w6 on 12/07/21
 * @project ds-algo-udemy
 */
public class RunLengthEncoding {
    private static String compressString(String str) {
        int n = str.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(str.charAt(i));
        }

        if(set.size() == n)
            return str;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < n) {
            int count = 1;
            int j = i + 1;
            while(j < n && str.charAt(i) == str.charAt(j)) {
                count++;
                j++;
            }
            sb.append(str.charAt(i));
            sb.append(count);
            i =  j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String ans = compressString(str);

        System.out.println(ans);

        scanner.close();
    }
}

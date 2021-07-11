package com.app.strings;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/07/21
 * @project ds-algo-udemy
 */
public class SearchAllOccurence {
    private static void searchAll(String str, String pattern) {
        int indx = 0;
        int n = str.length();
        while(indx < n) {
            //System.out.println(indx);
            int searchIndx = str.indexOf(pattern, indx);
            if(searchIndx !=-1) {
                System.out.println(searchIndx);
                indx = searchIndx + pattern.length();
            } else
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainStr = scanner.nextLine();

        String patternStr = scanner.nextLine();

        searchAll(mainStr, patternStr);

        scanner.close();
    }
}

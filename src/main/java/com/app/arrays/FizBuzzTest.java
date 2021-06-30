package com.app.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 30/06/21
 * @project ds-algo-udemy
 */
public class FizBuzzTest {
    private static List<String> fizbuzz(int n) {
        List<String> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                list.add("FizBuzz");
            } else if(i % 3 == 0) {
                list.add("Fizz");
            } else if(i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> result = fizbuzz(n);

        System.out.println(result);

        scanner.close();
    }
}

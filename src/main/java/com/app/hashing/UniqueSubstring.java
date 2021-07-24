package com.app.hashing;


import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 24/07/21
 * @project ds-algo-udemy
 */
public class UniqueSubstring {
    private static int uniqueSubstr(String str) {
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
                maxLen = Integer.max(maxLen, i - map.get(ch));
            }
            map.put(ch, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcaeba";

        int ans = uniqueSubstr(str);
        System.out.println(ans);
    }
}

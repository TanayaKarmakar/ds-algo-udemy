package com.app.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 01/07/21
 * @project ds-algo-udemy
 */
public class LongestBand {
    private static int longestBandApproach2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            int prev = nums[i] - 1;
            if(!set.contains(prev)) {
                int count = 1;
                int next = nums[i] + 1;
                while(set.contains(next)) {
                    count++;
                    next++;
                }
                maxLen = Integer.max(maxLen, count);
            }
        }

        return maxLen;
    }


    private static int longestBand(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])) {
                int count = 0;
                int k = nums[i];
                while(map.containsKey(k) && map.get(k)) {
                    map.put(k, false);
                    k--;
                    count++;
                }

                k = nums[i] + 1;
                while(map.containsKey(k) && map.get(k)) {
                    map.put(k, false);
                    k++;
                    count++;
                }

                maxLen = Integer.max(maxLen, count);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,9,3,0,18,5,2,4,10,7,12,6};

        int ans = longestBand(nums);

        System.out.println(ans);

        ans = longestBandApproach2(nums);

        System.out.println(ans);
    }
}

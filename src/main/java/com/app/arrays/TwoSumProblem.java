package com.app.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 30/06/21
 * @project ds-algo-udemy
 */
public class TwoSumProblem {
    private static int[] approach2(int[] nums, int sum) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            if(nums[start] + nums[end] == sum) {
                return new int[]{nums[start], nums[end]};
            } else if(nums[start] + nums[end] > sum)
                end--;
            else
                start++;
        }
        return new int[]{-1,-1};
    }

    private static int[] approach1(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(sum - num)) {
                return new int[] {num , sum - num};
            } else {
                set.add(num);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,3,-6,9,11};
        int sum = 4;

        int[] ans1 = approach1(nums, sum);

        System.out.println(Arrays.toString(ans1));

        int[] ans2 = approach2(nums, sum);

        System.out.println(Arrays.toString(ans2));
    }
}

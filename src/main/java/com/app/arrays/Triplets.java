package com.app.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 30/06/21
 * @project ds-algo-udemy
 */
public class Triplets {
    private static List<List<Integer>> triplets(int[] nums, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, i + 1, nums[i], sum, results);
        }
        return results;
    }

    private static void twoSum(int[] nums, int start, int num, int sum, List<List<Integer>> results) {
        int end = nums.length - 1;
        while(start < end) {
            int currentSum = num + nums[start] + nums[end];
            if(currentSum == sum) {
                List<Integer> result = List.of(num, nums[start], nums[end]);
                results.add(result);
                start++;
                end--;
            } else if(currentSum > sum) {
                end--;
            } else {
                start++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,15};
        int sum = 18;

        List<List<Integer>> triplets = triplets(nums,sum);

        System.out.println(triplets);
    }
}

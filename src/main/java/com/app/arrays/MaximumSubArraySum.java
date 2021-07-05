package com.app.arrays;

/**
 * @author t0k02w6 on 03/07/21
 * @project ds-algo-udemy
 */
public class MaximumSubArraySum {
    private static int maxSubarraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum < 0)
                currentSum = 0;

            maxSum = Integer.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,3,4,-2,6,-8,3};

        int ans = maxSubarraySum(nums);

        System.out.println(ans);

    }
}

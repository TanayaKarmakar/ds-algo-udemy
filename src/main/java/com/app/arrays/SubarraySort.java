package com.app.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/07/21
 * @project ds-algo-udemy
 */
public class SubarraySort {
    private static boolean isOutOfOrder(int[] nums, int i) {
        if(i == 0)
            return nums[0] > nums[1];
        else if(i == nums.length - 1)
            return nums[i] < nums[i - 1];
        else
            return nums[i] > nums[i + 1] || nums[i - 1] > nums[i];
    }

    private static int[] smallestSubarray(int[] nums) {
        if(nums.length == 1)
            return new int[] {-1, -1};
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(isOutOfOrder(nums, i)) {
                smallest = Integer.min(smallest, nums[i]);
                largest = Integer.max(largest, nums[i]);
            }
        }

        if(smallest == Integer.MAX_VALUE)
            return new int[] {-1, -1};

        int left = 0;
        while(smallest >= nums[left])
            left++;

        int right = nums.length - 1;
        while(largest <= nums[right])
            right--;

        return new int[]{left, right};

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,8,6,7,9,10,11};

        int[] ans = smallestSubarray(nums);

        System.out.println(Arrays.toString(ans));
    }
}

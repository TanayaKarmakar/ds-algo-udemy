package com.app.arrays;

/**
 * @author t0k02w6 on 01/07/21
 * @project ds-algo-udemy
 */
public class Mountains {
    private static int mountainLength(int[] nums) {
        int maxLen = Integer.MIN_VALUE;
        int n = nums.length;
        int i = 1;
        while(i < n - 1) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                int left = i;
                int count = 1;
                while (left >= 1 && nums[left - 1] < nums[left]) {
                    left--;
                    count++;
                }


                while (i < n - 1 && nums[i] > nums[i + 1]) {
                    i++;
                    count++;
                }

                maxLen = Integer.max(maxLen, count);
            } else {
                i++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};

        int maxLen = mountainLength(nums);

        System.out.println(maxLen);
    }
}

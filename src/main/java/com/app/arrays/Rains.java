package com.app.arrays;

/**
 * @author t0k02w6 on 02/07/21
 * @project ds-algo-udemy
 */
public class Rains {
    private static int trapTotalWater(int[] nums) {
        if(nums.length <= 2)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        int lMax = -1;
        int rMax = -1;
        int totalWater = 0;
        while(left < right) {
            if(nums[left] < nums[right]) {
                if(lMax == -1 || nums[lMax] < nums[left]) {
                    lMax = left;
                } else {
                    totalWater += (nums[lMax] - nums[left]);
                }
                left++;
            } else {
                if(rMax == -1 || nums[rMax] < nums[right]) {
                    rMax = right;
                } else {
                    totalWater += (nums[rMax] - nums[right]);
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int totalWater = trapTotalWater(nums);

        System.out.println(totalWater);
    }
}

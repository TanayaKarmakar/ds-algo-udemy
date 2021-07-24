package com.app.slidingwindow;

/**
 * @author t0k02w6 on 13/07/21
 * @project ds-algo-udemy
 */
public class SmallestWindowRequiredSum {
    private static int smallestWindowReqSum(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLength = n;

        while(right < n) {
            currentSum += nums[right];

            while(left <= right && currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == k) {
                System.out.println("Left - " + left + ": Right - " + right);
                minLength = Integer.min(minLength, (right - left + 1));
            }
            right++;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1,4,1,3,2,1,1,2};
        int sum = 8;

        int ans = smallestWindowReqSum(nums, sum);
        System.out.println(ans);
    }
}

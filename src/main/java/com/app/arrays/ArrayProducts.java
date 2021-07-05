package com.app.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/07/21
 * @project ds-algo-udemy
 */
public class ArrayProducts {
    private static int[] productArray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int l = 1;


        for(int i = 0; i < n; i++) {
            left[i] = left[i] * l;
            l = l * nums[i];
        }

        int r = 1;
        for(int i = n - 1; i >= 0; i--) {
            right[i] = left[i] * r;
            r = r * nums[i];
        }

        return right;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(Arrays.toString(productArray(nums)));
    }
}

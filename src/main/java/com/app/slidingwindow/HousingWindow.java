package com.app.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 13/07/21
 * @project ds-algo-udemy
 */
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "[" + first + " - " + second + "]";
    }
}

public class HousingWindow {
    private static List<Pair> findPlotEqualsK(int[] nums, int k) {
        List<Pair> optimalPairs = new ArrayList<>();

        int n = nums.length;
        int left = 0;
        int right = 0;
        int currentSum = 0;

        while(right < n) {
            currentSum += nums[right];

            while(left <= right && currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == k) {
                Pair pair = new Pair(left, right);
                optimalPairs.add(pair);
            }

            right++;
        }
        return optimalPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1,4,1,3,2,1,1,2};
        int sum = 8;

        List<Pair> optimalPairs = findPlotEqualsK(nums, sum);
        for(Pair pair: optimalPairs) {
            System.out.println(pair);
        }
    }
}

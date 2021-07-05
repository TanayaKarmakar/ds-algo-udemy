package com.app.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/07/21
 * @project ds-algo-udemy
 */
class Pair implements Comparable<Pair>{
    int num;
    int indx;

    public Pair(int num, int indx) {
        this.num = num;
        this.indx = indx;
    }

    @Override
    public int compareTo(Pair o) {
        return this.num - o.num;
    }
}

public class MinimumSwaps {
    private static int minSwaps(int[] nums) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];

        for(int i = 0; i < n; i++) {
            Pair pair = new Pair(nums[i], i);
            pairs[i] = pair;
        }

        Arrays.sort(pairs);

        boolean[] visited = new boolean[n];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i] || i == pairs[i].indx)
                continue;
            int node = i;
            int cycle = 0;
            while(!visited[node]) {
                visited[node] = true;
                int next = pairs[node].indx;
                node = next;
                cycle++;
            }

            ans += (cycle - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,1,3};
        int ans = minSwaps(nums);

        System.out.println(ans);
    }
}

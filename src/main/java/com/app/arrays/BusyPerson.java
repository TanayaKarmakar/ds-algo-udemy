package com.app.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/07/21
 * @project ds-algo-udemy
 */
public class BusyPerson {
    private static int countActivities(int[][] activities) {
        if(activities.length == 1)
            return 1;
        Arrays.sort(activities, (a1, a2) -> {
            if(a1[1] == a2[1])
                return a1[0] - a2[0];
            return a1[1] - a2[1];
        });

        int end = activities[0][1];
        int count = 1;
        for(int i = 1; i < activities.length; i++) {
            if(activities[i][0] >= end) {
                count++;
                end = activities[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] nums = {{7,9},{0,10},{4,5},{8,9},{4,10},{5,7}};

        int count = countActivities(nums);

        System.out.println(count);

    }
}

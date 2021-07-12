package com.app.strings;

import java.util.*;

/**
 * @author t0k02w6 on 11/07/21
 * @project ds-algo-udemy
 */
class NumberComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String o1Str = String.valueOf(o1);
        String o2Str = String.valueOf(o2);

        String o1o2 = o1Str + o2Str;
        String o2o1 = o2Str + o1Str;
        return o1o2.compareTo(o2o1) > 0 ? -1: 1;
    }
}

public class BiggestNumberString {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(11);
        nums.add(20);
        nums.add(30);
        nums.add(3);

        Collections.sort(nums, new NumberComparator());

        StringBuilder sb = new StringBuilder();
        for(Integer num: nums) {
            sb.append(num);
        }

        System.out.println(sb.toString());
    }
}

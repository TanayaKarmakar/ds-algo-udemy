package com.app.strings;

import java.util.*;

/**
 * @author t0k02w6 on 07/07/21
 * @project ds-algo-udemy
 */
class SubseqComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() == o2.length())
            return o1.compareTo(o2);
        return o1.length() - o2.length();
    }
}

public class SortSubsequences {
    private static void extractSubseq(String str, String curr, int indx, List<String> list) {
        if(indx == str.length()) {
            list.add(curr);
            return;
        }
        extractSubseq(str, curr + str.charAt(indx), indx + 1, list);
        extractSubseq(str, curr, indx + 1, list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        List<String> list = new ArrayList<>();

        extractSubseq(str, "", 0, list);

        Collections.sort(list, new SubseqComparator());

        System.out.println(list);

        scanner.close();
    }
}

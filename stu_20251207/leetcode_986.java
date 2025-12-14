package stu_20251207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_986 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sol_986(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }

    private static int[][] sol_986(int[][] firstList, int[][] secondList) {

        int secIdx = 0;
        int firIdx = 0;

        List<int[]> res = new ArrayList<>();
        while (secIdx < secondList.length && firIdx < firstList.length) {
            int start = Math.max(firstList[firIdx][0], secondList[secIdx][0]);
            int end = Math.min(firstList[firIdx][1], secondList[secIdx][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (firstList[firIdx][1] < secondList[secIdx][1]) {
                firIdx++;
            } else {
                secIdx++;
            }
        }

        int[][] result = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) {
            result[k] = res.get(k);
        }
        return result;

    }
}

package stu_20251019;

import java.util.Arrays;

public class leetcode_1718 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_1718(5)));

    }

    private static int[] sol_1718(int n) {
        int[] res = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];

        backTrace(res, used, 0, n);
        return res;
    }

    private static boolean backTrace(int[] res, boolean[] used, int idx, int n) {
        if (idx == res.length) return true;
        if (res[idx] != 0) return backTrace(res, used, idx + 1, n);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) {
                res[idx] = 1;
                used[num] = true;
                if (backTrace(res, used, idx + 1, n)) return true;
                res[idx] = 0;
                used[num] = false;
            } else {
                int numIdx = idx + num;
                if (numIdx < res.length && res[idx] == 0 && res[numIdx] == 0) {
                    res[idx] = res[numIdx] = num;
                    used[num] = true;
                    if (backTrace(res, used, idx + 1, n)) return true;
                    res[idx] = res[numIdx] = 0;
                    used[num] = false;
                }


            }

        }
        return false;
    }


}

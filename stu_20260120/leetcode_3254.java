package stu_20260120;

import java.util.Arrays;

public class leetcode_3254 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_3254(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }

    private static int[] sol_3254(int[] nums, int k) {
        if (k == 1) return nums;
        int[] ary = new int[nums.length - k + 1];

        for (int i = 0; i < ary.length; i++) {
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] - 1 != nums[j - 1]) {
                    ary[i] = -1;
                    break;
                }
                ary[i] = nums[j];
            }
        }

        return ary;
    }
}

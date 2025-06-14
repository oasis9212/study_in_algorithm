package stu_20250607;

import java.util.Arrays;
import java.util.Map;

public class leetcode_300 {

    public static void main(String[] args) {
        System.out.println(sol_300(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    private static int sol_300(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;


    }


}

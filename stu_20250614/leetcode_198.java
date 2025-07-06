package stu_20250614;

import java.util.Arrays;

public class leetcode_198 {
    public static void main(String[] args) {

        System.out.println(sol_198(new int[]{1, 2, 3, 4, 99, 3}));
        System.out.println(sol_198(new int[]{2, 1, 1, 2}));
        System.out.println(sol_198(new int[]{1, 1, 1}));
    }

    private static int sol_198(int[] nums) {

        if (nums.length <= 2) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }

        int[] firststmax = new int[nums.length];
        firststmax[0] = nums[0];
        firststmax[1] = nums[1];
        firststmax[2] = nums[0] + nums[2];
        if (nums.length == 3) {
            Arrays.sort(firststmax);
            return firststmax[firststmax.length - 1];
        }

        for (int i = 3; i < nums.length; i++) {
            int val = Math.max(firststmax[i - 1], firststmax[i - 2] + nums[i]);
            val = Math.max(val, firststmax[i - 3] + nums[i]);
            firststmax[i] = val;
        }


        return firststmax[nums.length - 1];
    }
}

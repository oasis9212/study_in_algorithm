package stu_20260202;

import java.util.Arrays;

public class leetcode_80 {
    public static void main(String[] args) {
        System.out.println((sol_80(new int[]{0,0,1,1,1,1,2,3,3})));

    }

    private static int sol_80(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int start = nums[0];
        int count = 1;
        int write = 1; // 덮어쓸 위치

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == start) {
                count++;
            } else {
                start = nums[i];
                count = 1;
            }

            if (count <= 2) {
                nums[write] = nums[i];
                write++;
            }
        }
        return write;
    }
}

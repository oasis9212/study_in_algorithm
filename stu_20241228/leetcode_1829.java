package stu_20241228;

import java.util.Arrays;

public class leetcode_1829 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;
        System.out.println(Arrays.toString(sol_1829(nums, maximumBit)));
    }

    private static int[] sol_1829(int[] nums, int maximumBit) {

        int maxbit = (int) Math.pow(2, maximumBit) - 1;
        int[] result = new int[nums.length];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = (xor ^ nums[i]);
            result[nums.length - i - 1] = xor ^ maxbit;
        }


        return result;
    }


}

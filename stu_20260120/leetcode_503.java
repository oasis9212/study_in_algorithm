package stu_20260120;

import java.util.Arrays;


public class leetcode_503 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sol_503(new int[]{1, 2, 3, 4, 3})));
    }

    private static int[] sol_503(int[] nums) {
        int n = nums.length;
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = -1;

            for (int j = 1; j < n; j++) {
                int idx = (i + j) % n;
                if(nums[idx]> nums[i]){
                    ary[i] = nums[idx];
                    break;
                }
            }

        }
        return ary;
    }
}

package stu_20251019;

import java.util.Arrays;

public class leetcode_75 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_75(new int[]{2, 0, 2, 1, 1, 0})));
    }

    private static int[] sol_75(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int color = 0; color < 3; color++) {
            while (count[color]-- > 0) {
                nums[index++] = color;
            }
        }

        return nums;
    }
}

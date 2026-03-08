package stu_20260303;


public class leetcode_413 {
    public static void main(String[] args) {
        System.out.println(sol_413(new int[]{1, 2, 3, 4, 6, 8, 10, 12}));
    }

    private static int sol_413(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int diff = nums[1] - nums[0];
        int arySize = 2;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (diff == nums[i] - nums[i - 1]) {
                arySize++;
            } else {
                arySize = 2;
                diff = nums[i] - nums[i - 1];
            }
            if (arySize >= 3) {
                res += arySize - 3 + 1;
            }
        }

        return res;

    }
}

package stu_20251214;


public class leetcode_1004 {
    public static void main(String[] args) {
        System.out.println(sol_1004(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        //left =5
    }

    private static int sol_1004(int[] nums, int k) {
        int left = 0;
        int zero = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            while (zero > k) {
                if (nums[left++] == 0) zero--;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

package stu_20260103;

public class leetcode_504 {

    public static void main(String[] args) {

        System.out.println(sol_504(new int[]{-1, 2, 5, 4}));
    }

    private static int sol_504(int[] nums) {
        int total = 0;

        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        for (int n : nums) {
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);

            total += n;
        }

        // 전부 음수면 원형 불가
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}

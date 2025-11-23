package stu_20251109;

public class leetcode_3191 {
    public static void main(String[] args) {
        System.out.println(sol_3191(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(sol_3191(new int[]{0, 1, 1, 1}));
    }

    private static int sol_3191(int[] nums) {
        int zeroIdx = 0;
        int count = 0;
        while (zeroIdx < nums.length) {
            if (nums[zeroIdx] == 0) {
                if (zeroIdx + 2 >= nums.length) {
                    return -1;
                }
                nums[zeroIdx] = 1;
                nums[zeroIdx + 1] ^= 1;
                nums[zeroIdx + 2] ^= 1;
                count++;
            }
            zeroIdx++;
        }
        return count;
    }
}

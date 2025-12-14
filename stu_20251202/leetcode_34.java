package stu_20251202;

import java.util.Arrays;

public class leetcode_34 {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(sol_34(new int[]{5, 7, 7, 8, 8, 10}, 8)));
       // System.out.println(Arrays.toString(sol_34(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(sol_34(new int[]{2,2}, 2)));
    }

    private static int[] sol_34(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
}

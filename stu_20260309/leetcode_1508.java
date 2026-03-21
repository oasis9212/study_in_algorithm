package stu_20260309;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_1508 {
    public static void main(String[] args) {
        System.out.println(sol_1508(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    private static int sol_1508(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                pq.add(sum);
            }
        }
        int start = 1;
        while (start < left) {
            pq.poll();
            start++;
        }
        int res = 0;
        int MOD = 1_000_000_007;
        while (left <= right) {
            res = (res + pq.poll()) % MOD;
            left++;
        }


        return res;
    }
}

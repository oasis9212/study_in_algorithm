package stu_20251207;

import java.util.HashMap;
import java.util.Map;

public class leetcode_930 {
    public static void main(String[] args) {
        System.out.println(sol_930(new int[]{1,0,1,0,1}, 2));
    }

    private static int sol_930(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}

package stu_20251214;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_2799 {
    public static void main(String[] args) {
        System.out.println(sol_2799(new int[]{1, 3, 1, 2, 2}));
        System.out.println(sol_2799(new int[]{1,1,1,1,1}));
    }

    private static int sol_2799(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int need = set.size();

        int left = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() == need) {
                total += nums.length - i;

                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return total;


    }
}

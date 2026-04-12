package stu_20260406;

import java.util.*;

public class leetcode_3843 {
    public static void main(String[] args) {
        System.out.println(sol_3843(new int[]{20, 10, 30, 30}));
    }

    private static int sol_3843(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        // 숫자 , 갯수
        for (int i : nums) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }
        // 갯수 , 숫자.
        Map<Integer, Integer> Count = new HashMap<>();
        for (int key : numCount.values()) {
            Count.put(key, Count.getOrDefault(key,0)+1);
        }
        for(int i: nums){
            if(Count.get(numCount.get(i))==1){
                return i;
            }
        }
        return -1;
    }
}

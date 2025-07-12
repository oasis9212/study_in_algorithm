package stu_20250706;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_2149 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_2149(new int[]{3, 1, -2, -5, 2, -4})));
    }

    private static int[] sol_2149(int[] nums) {

        Queue<Integer> PlusQ = new LinkedList<>();
        Queue<Integer> MinusQ = new LinkedList<>();

        int[] ary = new int[nums.length];

        int idx = 0;

        for (int n : nums) {
            if (n > 0) {
                PlusQ.add(n);
            } else {
                MinusQ.add(n);
            }

            while (true) {
                if (idx % 2 == 0 && !PlusQ.isEmpty()) {
                    ary[idx] = PlusQ.poll();
                    idx++;
                } else if (idx % 2 == 1 && !MinusQ.isEmpty()) {
                    ary[idx] = MinusQ.poll();
                    idx++;
                } else {
                    break;
                }
            }


        }

        return ary;
    }
}

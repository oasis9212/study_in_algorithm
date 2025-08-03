package stu_20250723;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1823 {
    public static void main(String[] args) {
        System.out.println(sol_1823(5,2));

    }

    private static int sol_1823(int n, int k) {

        if (n == 1) return 0; // base case: only one person left
        return (sol_1823(n - 1, k) + k) % n;
    }
}

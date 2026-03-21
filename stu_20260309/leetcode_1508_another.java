package stu_20260309;

import java.util.PriorityQueue;

public class leetcode_1508_another {
    public static void main(String[] args) {
        System.out.println(sol_1508(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    private static int sol_1508(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.sum - o2.sum));
        for (int i = 0; i < n; i++) {
            pq.add(new Node(nums[i], i + 1));
        }
        
        long res = 0;
        for (int i = 1; i <= right; i++) {
            Node cur = pq.poll();
            if (i >= left) {
                res = (res + cur.sum) % MOD;
            }
            if (cur.next < n) {
                pq.add(new Node(cur.sum + nums[cur.next], cur.next + 1));
            }
        }

        return (int) res;
    }
}


class Node {
    int sum;
    int next;

    public Node(int sum, int next) {
        this.sum = sum;
        this.next = next;
    }
}
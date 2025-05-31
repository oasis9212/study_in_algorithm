package stu_20250526;


import java.util.*;

public class leetCode_2305 {
    public static void main(String[] args) {
        System.out.println(sol_2305(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3));
        System.out.println(sol_2305(new int[]{8, 15, 10, 20, 8}, 2));
        System.out.println(sol_2305_another(new int[]{8, 15, 10, 20, 8}, 2));
    }

    private static int sol_2305_another(int[] cookies, int k) {
        int n = cookies.length;

        // 누적합 prefix[i] = cookies[0] + ... + cookies[i-1]
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + cookies[i];
        }

        // dp[i][j] = i개의 쿠키를 j명에게 나눴을 때 최소의 최대 합
        int[][] dp = new int[n + 1][k + 1];

        // 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }



        // 점화식
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int x = 0; x < i; x++) {
                    int sum = prefix[i] - prefix[x];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[x][j - 1], sum));
                }
            }
        }

        return dp[n][k];

    }
    // 시발 ...,  그리디 +



    private static int sol_2305(int[] cookies, int k) {
        int left = 0;
        int right = 0;

        for (int cookie : cookies) {
            left = Math.max(left, cookie); // 한 명이 최소 받을 수 있는 최대 쿠키
            right += cookie;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (candis(cookies, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean candis(int[] cookies, int k, int mid) {
        int sum = 0;
        int count = 1;

        for (int cookie : cookies) {
            if (sum + cookie > mid) {
                count++;
                sum = 0;
            }
            sum += cookie;
        }

        return count <= k;
    }
}


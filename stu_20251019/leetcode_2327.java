package stu_20251019;

public class leetcode_2327 {
    public static void main(String[] args) {
        System.out.println(sol_2327(4, 1, 3));
    }

    private static int sol_2327(int n, int delay, int forget) {
        long INF = 1000000007;

        long[] day = new long[n + 1];
        day[1] = 1;

        long sum = 0;

        for (int i = 2; i <= n; i++) {
            int secretRange = i - delay;
            int forgetRange = i - forget;

            if (secretRange >= 1) {
                sum = (sum + day[secretRange]) % INF;
            }
            if (forgetRange >= 1) {
                sum = (sum - day[forgetRange] + INF) % INF;
            }
            day[i] = sum;
        }

        long result = 0;
        int start = Math.max(1, n - forget + 1);
        for (int i = start; i <= n; i++) {
            result = (result + day[i]) % INF;
        }

        return (int) result;
    }

}

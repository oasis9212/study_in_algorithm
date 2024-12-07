package stu_20241105;

public class 퍼즐게임 {
    public static void main(String[] args) {
        int[] diffs = {1, 328, 467, 209, 54};
        int[] times = {2, 7, 1, 4, 3};
        long limit = 1723;
        int max = 0;
        int min = 1;
        for (int i : diffs) {
            max = Math.max(max, i);
        }
        int ans = Integer.MAX_VALUE;
        int a = sole(diffs, times, limit, max, min, ans);
        System.out.println(a);


    }

    private static int sole(int[] diffs, int[] times, long limit, int max, int min, int ans) {
        if (min > max) {
            return ans;
        }

        int middle = (max - min) / 2 + min;
        long total = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] < middle) {
                total += times[i];
            } else {
                total += (long) (times[i - 1] + times[i]) * (diffs[i] - middle) + times[i];
            }
            if (total > limit) {
                return sole(diffs, times, limit, max, middle + 1, ans);  // 이미 초과되면 더 높은 값을 봐야함.
            }
        }
        if (ans > middle) {
            ans = (int) middle;
        }
        return sole(diffs, times, limit, middle - 1, min, ans);

    }


}

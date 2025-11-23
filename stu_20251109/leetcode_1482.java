package stu_20251109;

public class leetcode_1482 {
    public static void main(String[] args) {
        System.out.println(sol_1482(new int[]{1, 10, 3, 10, 2}, 3, 1));
    }

    private static int sol_1482(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canmake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

    private static boolean canmake(int[] bloomDay, int m, int k, int day) {
        int flower = 0;
        int bouquet = 0;

        for (int bloom : bloomDay) {
            if (day >= bloom) {
                flower++;
                if (flower == k) {
                    flower = 0;
                    bouquet++;
                }
            } else {  // 연속적으로 만들수 없다고 판단.
                flower = 0;
            }
            if (bouquet >= m) return true;
        }
        return false;
    }
}

package stu_20250310;

import java.util.Arrays;

public class leetcode_3015 {
    public static void main(String[] args) {
        //   System.out.println(Arrays.toString(sol_3015(3, 1, 3)));
        System.out.println(Arrays.toString(sol_3015(5, 2, 4)));
        System.out.println(Arrays.toString(sol_3015(4, 1, 1)));
        System.out.println(Arrays.toString(sol_3015(5, 1, 5)));
    }

    private static int[] sol_3015(int n, int x, int y) {

        int shortcutstart = Math.min(x - 1, y - 1);
        int shortcutend = Math.max(x - 1, y - 1);
        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            for (int j = i; j < result.length; j++) {
                if (i == j) continue;
                int range = j - i;
                int usingshort = Math.abs(i - shortcutstart) + Math.abs(j - shortcutend) + 1;
                result[Math.min(range, usingshort) - 1] += 2;
            }
        }
        return result;
    }
}

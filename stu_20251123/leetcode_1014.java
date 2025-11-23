package stu_20251123;

public class leetcode_1014 {
    public static void main(String[] args) {
        System.out.println(sol_1014(new int[]{8, 1, 5, 2, 6}));
    }

    private static int sol_1014(int[] values) {
        int max = 0;
        int maxval = values[0];  // +0  포함

        for (int i = 1; i < values.length; i++) {
           max = Math.max(max, maxval+values[i]-i);
           maxval = Math.max(maxval,values[i]+i);
        }

        return max;
    }
   /* private static int sol_1014(int[] values) {
        int max = 0;
        int maxidx = 0;

        for (int i = 0; i < values.length; i++) {
            if (i != 0 && values[maxidx] > values[i] + (i - maxidx)) {
                continue;
            } else {
                maxidx = i;
            }
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(values[i] + values[j] + i - j, max);

            }
        }

        return max;
    }*/
}

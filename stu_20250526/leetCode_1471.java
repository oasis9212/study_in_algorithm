package stu_20250526;

import java.util.Arrays;

public class leetCode_1471 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sol_1471(new int[]{-7,22,17,3}, 2)));
    }

    private static int[] sol_1471(int[] arr, int k) {

        Arrays.sort(arr);
        int[] ans = new int[k];

        int pluspoint = arr.length - 1;

        int minuspoint = 0;

        int idx = 0;
        int midval = arr[(arr.length-1) / 2];


        while (idx < k) {
            int pv = Math.abs(arr[pluspoint] - midval);
            int mv = Math.abs(arr[minuspoint] - midval);
            if (pv >= mv) {
                ans[idx] = arr[pluspoint];
                pluspoint--;
                idx++;
            } else {
                ans[idx] = arr[minuspoint];
                minuspoint++;
                idx++;
            }

        }

        return ans;
    }
}

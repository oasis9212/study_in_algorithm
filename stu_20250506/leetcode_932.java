package stu_20250506;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_932 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_932(4)));

    }

    private static int[] sol_932(int n) {

        HashMap<Integer, int[]> record = new HashMap<>();

        return result(n, record);

    }

    private static int[] result(int n, HashMap<Integer, int[]> record) {
        // 값이 5일경우 1~4 까지 값을 저장한다.
        // 우선 등차수열 형식을 값을 가질경우 성립이 안된다.
        // 따라서 홀수 배열과 짝수 배열을 따로따로 분리하여 저장을 시킨다.
        // n=  3 일 경우
        /*   n=1 [1]
        *    n=2 [1,2]
        *    홀수 배열의 값을 따로 저장
        *    짝수 배열을 이후에 저장한다.
        * */

        if (record.containsKey(n)) return record.get(n);

        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int[] odd = result((n + 1) / 2, record);
            int[] even = result(n / 2, record);

            int idx = 0;
            for (int x : odd) res[idx++] = 2 * x - 1;
            for (int x : even) res[idx++] = 2 * x;
        }
        record.put(n, res);
        return res;
    }
}

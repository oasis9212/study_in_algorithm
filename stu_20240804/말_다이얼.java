package stu_20240804;

import java.util.ArrayList;
import java.util.List;

public class 말_다이얼 {
    public static void main(String[] args) {
        int n = 2;


        long MOD = 1_000_000_007;
        long[] arr = new long[10];
        for (int i = 0; i <= 9; i++) {
            arr[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            long[] temp = new long[10];
            temp[0] = (arr[4] + arr[6]) % MOD;
            temp[1] = (arr[6] + arr[8]) % MOD;
            temp[2] = (arr[7] + arr[9]) % MOD;
            temp[3] = (arr[4] + arr[8]) % MOD;
            temp[4] = (arr[3] + arr[9] + arr[0]) % MOD;
            temp[5] = 0;
            temp[6] = (arr[7] + arr[1] + arr[0]) % MOD;
            temp[7] = (arr[2] + arr[6]) % MOD;
            temp[8] = (arr[1] + arr[3]) % MOD;
            temp[9] = (arr[4] + arr[2]) % MOD;
            arr = temp;
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + arr[i]) % MOD;
        }
        System.out.println(sum);
    }

}
package stu_20250921;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class 보행자천국 {
    static int  MOD = 20170805;

    public static void main(String[] args) {
        System.out.println(sol_보행자천국(3,6,new int[][]{{0, 2, 0, 0, 0, 2},{0, 0, 2, 0, 1, 0},{1, 0, 0, 2, 2, 0}}));
    }

    private static int sol_보행자천국(int m, int n, int[][] cityMap) {

        int[][][] dp = new int[m][n][2];


        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (cityMap[i][j] == 1) {  // 아예 못간다
                    dp[i][j][0] = dp[i][j][1] = 0;
                    continue;
                }
                if (i > 0) {  // 세로 0
                    if (cityMap[i-1][j] == 2) {
                        dp[i][j][1] = dp[i-1][j][1];  // (0,2)
                    } else {
                        dp[i][j][1] = (dp[i][j][1] + dp[i-1][j][0] + dp[i-1][j][1]) % MOD;  //0
                    }
                }


                if (j > 0) {
                    if (cityMap[i][j-1] == 2) {
                        dp[i][j][0] =dp[i][j-1][0];   // (1,0)
                    } else {
                        dp[i][j][0] = (dp[i][j][0] + dp[i][j-1][0] + dp[i][j-1][1]) % MOD;  // 0
                    }
                }
            }
        }

        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }


}

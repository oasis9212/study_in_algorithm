package stu_20250119;

import java.util.Arrays;

public class 거스름돈 {

    public static void main(String[] args) {

        System.out.println(sol_rest(5,new int[]{1,2,5}));

    }

    private static int sol_rest(int n, int[] money) {
        final long INF=1000000007;

        long[] nlen=new long[n+1];

        for (int i = 0; i < money.length; i++) {
            int m=money[i];
            if(m>n) continue;
            nlen[m]++;  // 최초로 생성한 것. 예 5  는 동전은  nlen[5] +=1 한것이다.
            for (int j = 1; j < nlen.length; j++) {
                if(j<m) continue;
                nlen[j]+=nlen[j-m];
                nlen[j]%=INF;
            }
        }
        return (int)nlen[n];
    }
}

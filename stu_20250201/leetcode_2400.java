package stu_20250201;

import java.math.BigInteger;

public class leetcode_2400 {
    public static void main(String[] args) {
        System.out.println(sol_2400(989, 1000, 99));
        //1000000007
    }

    private static int sol_2400(int startPos, int endPos, int k) {
        /*  예제  start =1 end=2 k=3 으로 한다.
         * 시작과 끝을 비교하고 앞으로 가는지 뒤로 가는지 상관없이 앞으로 가는 방향으로만 설정한다.
         * */
        int startPoint = Math.min(startPos, endPos);
        int endPoint = Math.max(startPos, endPos);
        if (startPos + k < endPoint || (k - (endPoint - startPoint)) % 2 == 1) {
            return 0;
        }
        /*
         * 1. 시작점+k 보다 end값이 크면 갈수 있는방법 없다.
         * 2. k-시작과끝의 차이거리가 홀수일경우 방법이 없다.
         * */
        int r = (endPoint - startPoint + k) / 2;
        /* 다음과 같은 형식은 이렇게 나온다.(오른쪽 왼쪽 일단 취급)
           (r) = endPoint - startPoint;  이동해야할 거리(오른쪽)
         (k-r) 은 왼쪽
        r-(k-r) = endPoint - startPoint;
        2r=   endPoint - startPoint +k;
        r= (endPoint - startPoint + k) / 2;
        * */

        // 여기까지는 조합으로 사용하는것까지는 방법은 알았지만 나머지 부분은 gpt 사용했습니다.
        return Comb(k, r, 1000000007);
    }

    private static int Comb(int k, int r, int INF) {
        long num = 1;
        long den = 1;

        // 조합 사용.
        for (int i = 0; i < r; i++) {
            num = (num * (k - i)) % INF;
            den = (den * (i + 1)) % INF;
        }
        /*
         *  다음식은 모듈러 함수를 사용한다.
         *  모듈러 함수는 다음과 같은 효과를 보여주는데
         *  곱샘을 할경우에 나눗셈을 하는 효과를 나타낸다. 자세한건. 깃.
         * */


        return (int) ((num * modInverse(den, INF) % INF));
    }

    private static long modInverse(long den, int inf) {
        return BigInteger.valueOf(den).modInverse(BigInteger.valueOf(inf)).longValue();
    }

   /* private static int goProcess(int plus, int minus, int count) {
        if (plus == 0 || minus == 0) {
            return count % 1000000007;
        }
        return goProcess(plus, minus - 1, count) + goProcess(plus - 1, minus, count);
        // 재귀로 푸니깐 시간 리미트 걸렸다.
    }*/
}


package 스스로한다;

import java.math.BigInteger;

public class 계산기 {
    public static void main(String[] args) {
        long INF = 1000000007;
        long den = 2;  // b -1


        // 모듈러 연산을 수행
//        long result = (den * invDen) % INF;
        System.out.println(BigInteger.valueOf(den).modInverse(BigInteger.valueOf(INF)).longValue());

        long i = 6L * 500000004;
        System.out.println((long) i % INF);
  //      System.out.println("결과: " + result); // 1이 나와야 함
    }
}

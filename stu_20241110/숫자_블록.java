package stu_20241110;

import java.util.*;

public class 숫자_블록 {
    static List<Integer> primeval = new ArrayList<>();

    public static void main(String[] args) {
        // 소수라면 1
        // 아닐시 작은수 부터 나뉘서 나머지가 0 인것에서 몫값
        long begin = 52;
        long end = 52;
        int[] result = new int[Math.toIntExact(end - begin + 1)];
        int loc = 0;
        //  boolean[] prime = getprime(Math.toIntExact(end));


        while (begin <= end) {
            int val = getval2(begin);
            begin++;
            result[loc] = val;
            loc++;
        }

        System.out.println(Arrays.toString(result));
    }

    private static int getval2(long intval) {

        if(intval==1) return 0;
        int max=1;

        // 소수 찾는 것이고요.
        for (int i = 2; (long) i * i <= intval; i++) {

            if (intval % i == 0 ) {  // 해당 값이  나뉘어 떨어지면
                max=i;
                if(intval / i <= 10_000_000){
                    return (int) (intval / i);
                }
            }
        }
        return max;
    }

    private static boolean[] getprime(int end) {
        boolean[] prime = new boolean[end + 1];
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (prime[i]) {
                continue;
            }

            primeval.add(i);

            // i의 배수라면 소수가 아니므로 true
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
        return prime;
    }

    private static int getval(int begin, boolean[] prime) {
        if (begin == 1) {
            return 0;
        } else if (!prime[begin]) {
            return 1;
        }
        for (Integer integer : primeval) {
            if (begin % integer == 0 && begin / integer < 10_000_000) {
                return begin / integer;
            }
        }

        return 1;
    }

}

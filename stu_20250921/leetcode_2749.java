package stu_20250921;

import java.util.HashSet;
import java.util.Set;

public class leetcode_2749 {

    public static void main(String[] args) {

        System.out.println(sol_2749(5, -21));
    }

    private static int sol_2749(int num1, int num2) {

        // 1. num1 - ( 2i + num2)  == 0  ?  횟수  : 아니면 num1 = num1 - ( 2i + num2)
        // 2. num1 -  ( 2i + num2)  == 0  ?  횟수  : 아니면 num1 = num1 - ( 2i + num2)
        // 반복....
        // 마지막 num1 -  ( 2i + num2)  == 0 몇번 한 휫수를 찾아라
        for (int i = 1; i <= 60; i++) {
            long val=  (long) num1 - (long) num2 * i;  // 횟수를 뜻한다.

            if(val < i) continue; // 만들수 없다.   2^i 이 현재 값 작을때 못한다.
            if(Long.bitCount(val)<= i){
                return i;
            }

        }
        return -1;
    }
}

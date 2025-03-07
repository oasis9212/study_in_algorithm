package stu_20250304;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_2657 {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(sol_2657(new int[]{2,3,1}, new int[]{3,1,2})));


    }

    private static int[] sol_2657(int[] A, int[] B ) {
        int[] result=new int[A.length];

        Set<Integer> se=new HashSet<>();
            int count=0;
        for (int i = 0; i < A.length; i++) {
            if(!se.add(A[i])) {
                count++;
            }
            if(!se.add(B[i])){
                count++;
            }
            result[i]=count;

        }

        return result;


    }
}

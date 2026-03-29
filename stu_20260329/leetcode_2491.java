package stu_20260329;

import java.util.Arrays;

public class leetcode_2491 {

    public static void main(String[] args) {
        System.out.println( sol_2491( new int[]{3,2,5,1,3,4}));
    }

    private static long sol_2491(int[] skill) {
        Arrays.sort(skill);

        int divide=skill[0]+skill[skill.length-1];
        long sum= (long) skill[0] *skill[skill.length-1];
        for (int i = 1; i < skill.length/2; i++) {
                if(divide==skill[i]+skill[skill.length-i-1]){
                    sum+= (long) skill[i] *skill[skill.length-i-1];
                }else{
                    return -1;
                }
        }

        return sum;
    }
}

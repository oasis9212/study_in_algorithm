package stu_20251103;

import java.util.Arrays;

public class leetcode_1561 {
    public static void main(String[] args) {
        System.out.println(sol_1561(new int[]{9,8,7,6,5,1,2,3,4}));
    }
    // 1 2 3 4 5 6 7 8 9

    //  1 8 9
    //  2 6 7
    //  3 4 5
    private static int sol_1561(int[] piles) {
        Arrays.sort(piles);
        int bigSelector= piles.length-1;
        int smallSelector  = 0;

        int middleSum=0;

        while (bigSelector> smallSelector){

            middleSum+=piles[bigSelector-1];

            smallSelector++;
            bigSelector-=2;
        }

        return middleSum;
    }
}

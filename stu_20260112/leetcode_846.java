package stu_20260112;

import java.util.Arrays;

public class leetcode_846 {
    public static void main(String[] args) {
        System.out.println(sol_846(new int[]{1,2,3,6,2,3,4,7,8},3));
    }

    private static boolean sol_846(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0){
            return false;
        }else if( groupSize ==1){
            return true;
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if(hand[i]>=0){
                if(!groupUse(hand,groupSize,i)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean groupUse(int[] hand, int groupSize, int idx) {
        int num=hand[idx]+1;
        hand[idx]=-1;
        int count=1;
        idx +=1;
        while(idx < hand.length && count < groupSize){
            if(hand[idx]==num){
                num =  hand[idx] +1;
                hand[idx]=-1;
                count++;
            }
            idx++;
        }
        return count == groupSize;
    }

}

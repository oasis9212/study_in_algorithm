package stu_20260329;

import java.util.Arrays;

public class leetcode_2294 {
    public static void main(String[] args) {
        System.out.println(sol_2294(new int[]{3,6,1,2,5},2));
        System.out.println(sol_2294(new int[]{1,2,3},1));
        System.out.println(sol_2294(new int[]{2,2,4,5},0));
    }

    private static int sol_2294(int[] nums, int k) {
        Arrays.sort(nums);

        int compareNum=nums[0];
        if(nums.length==1)return 1;
        int arySize=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-compareNum>k){
                arySize++;
                compareNum=nums[i];
            }
        }
        return arySize;
    }
}

package stu_20240701;


import java.util.Arrays;

public class findValueOfPartition {

    public static void main(String[] args) {
        int[] nums = {100,1,10};

        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length-1;i++){
            int compareval=nums[i+1] -nums[i];
            min=Math.min(min,compareval);
        }
        System.out.println(min);


    }
}

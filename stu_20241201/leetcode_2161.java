package stu_20241201;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_2161 {
    public static void main(String[] args) {
        int[] nums={9,12,5,10,14,3,10};
        int pivot=10;
        Queue<Integer> less= new LinkedList<>();
        Queue<Integer> more= new LinkedList<>();
        int count=0;

        for (int i = 0; i < nums.length; i++) {
            if(pivot > nums[i]){
                less.add(nums[i]);

            }else if(pivot < nums[i]){
                more.add(nums[i]);
            }else{
                count++;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if(!less.isEmpty()){
                nums[i]=less.poll();
                continue;
            }else if(count>0){
                count--;
                nums[i]=pivot;
                continue;
            }else if(!more.isEmpty()){
                nums[i]=more.poll();
                continue;
            }
        }

        System.out.println(Arrays.toString(nums));



    }
}

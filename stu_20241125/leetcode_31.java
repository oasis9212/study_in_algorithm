package stu_20241125;

import java.util.Arrays;

public class leetcode_31 {
    public static void main(String[] args) {

         int[] nums = {4,1,2,3};

        boolean last = true;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {  // 뒷 배열에서 바로 발견된 순으로
                last = false;
                seekchange(nums, i - 1);
                break;
            }
        }

        if (last) {
            Arrays.sort(nums);
        }

        System.out.println(Arrays.toString(nums));

    }

    private static void seekchange(int[] nums, int changePos) {

        for (int k = nums.length - 1; k > changePos; k--) {
            if (nums[k] > nums[changePos]) {
                int temp = nums[k];
                nums[k] = nums[changePos];
                nums[changePos] = temp;
            }
        }
        int end=nums.length-1;
        changePos++;
        while (changePos< end){
            int temp = nums[end];
            nums[end]=nums[changePos];
            nums[changePos]= temp;

            changePos++;
            end--;
        }



    }


}


//[4, 8, 7, 1, 2, 3, 5, 6]
//[4, 6, 5, 3, 2, 1, 7, 8]
//[4, 1, 2, 3, 5, 6, 7, 8]


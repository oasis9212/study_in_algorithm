package stu_20260202;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_870 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_870(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
    }

    private static int[] sol_870(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((b, a) -> Integer.compare(a[1], b[1]));
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new int[]{i,nums2[i]});
        }
        int[] result=new int[nums1.length];
        int min=0;
        int max=nums1.length-1;

        while (!pq.isEmpty()){
            int[] a =pq.poll();
            if(a[1]<nums1[max]){
                result[a[0]]=nums1[max];
                max--;
            }else{
                result[a[0]]=nums1[min];
                min++;
            }
        }
        return result;
    }
}

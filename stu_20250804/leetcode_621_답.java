package stu_20250804;

import java.util.Arrays;

public class leetcode_621_답 {
    public static void main(String[] args) {
        System.out.println(sol_621_답(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    private static int sol_621_답(char[] tasks, int n) {
        int ans=0;
        int[] arr=new int[26];
        for(int i=0;i<tasks.length;i++){
            char ch=tasks[i];
            arr[(int)ch-'A']++;
        }
        //System.out.println(Arrays.toString(arr));
        //System.out.println(tasks.length);
        Arrays.sort(arr);
        int max=arr[25]-1;
        int m=(max)*n;
        for(int i=24;i>=0 && arr[i]>0;i--){
            m-=Math.min(arr[i],max);
        }
        ans=m>0?tasks.length+m:tasks.length;
        return ans;


    }
}

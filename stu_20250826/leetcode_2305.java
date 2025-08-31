package stu_20250826;

public class leetcode_2305 {
    public static void main(String[] args) {
        System.out.println(sol_2305(new int[]{6,1,3,2,2,4,1,2},3));
    }

    private static int sol_2305(int[] cookies , int k) {
        int[] group= new int[k];

        return backtrack(0,cookies,group,0);

    }

    private static int backtrack(int idx, int[] cookies, int[] group, int max) {
       if(idx == cookies.length){
           return max;
       }
       int min=Integer.MAX_VALUE;

        for (int i = 0; i < group.length; i++) {
            group[i]+=cookies[idx];
            int val=backtrack(idx+1,cookies,group,Math.max(group[i],max));
            min=Math.min(min,val);
            group[i]-=cookies[idx];
            if(group[i]==0) break;
        }
        return min;
    }


}

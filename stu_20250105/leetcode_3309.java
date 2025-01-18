package stu_20250105;

public class leetcode_3309 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,8,16};
        String a= Integer.toBinaryString(nums[0]);
        String b= Integer.toBinaryString(nums[1]);
        String c= Integer.toBinaryString(nums[2]);

        int ans=Math.max(0,Integer.parseInt(a+b+c,2));
        ans=Math.max(ans,Integer.parseInt(a+c+b,2));
        ans=Math.max(ans,Integer.parseInt(b+a+c,2));
        ans=Math.max(ans,Integer.parseInt(b+c+a,2));
        ans=Math.max(ans,Integer.parseInt(c+a+b,2));
        ans=Math.max(ans,Integer.parseInt(c+b+a,2));
        int x=3;
        System.out.println( x >>= 1);
        System.out.println(ans);
    }
}

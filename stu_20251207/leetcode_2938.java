package stu_20251207;

public class leetcode_2938 {
    public static void main(String[] args) {
        System.out.println(sol_2938("101"));
    }

    private static long sol_2938(String s) {
        long zerosum=0;
        long zerocount=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)=='0'){
                zerocount++;
            }else{
                zerosum+=zerocount;
            }
        }
        return zerosum;
    }
}

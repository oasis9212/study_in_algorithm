package stu_20260219;

public class leetcode_837 {
    public static void main(String[] args) {
        System.out.println(sol_837(10,2,10));
    }

    private static double sol_837(int n, int k, int maxPts) {
        if( k == 0  || n >= k+maxPts){
            return 1.0;
        }
        double[] dp= new double[n+1];
        dp[0]=1.0;
        double windowSum=1.0;
        double result=0;

        for (int i = 1; i <= n; i++) {
            dp[i]= windowSum / maxPts;

            if(i<k){
                windowSum+= dp[i];
            }else{
                result += dp[i];
            }

            if(i-maxPts>=0){
                windowSum-= dp[i-maxPts];
            }
        }

        return result;
    }
}

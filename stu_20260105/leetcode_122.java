package stu_20260105;

public class leetcode_122 {
    public static void main(String[] args) {
        System.out.println(sol_122(new int[]{7,1,5,3,6,4}));
    }

    private static int sol_122(int[] prices) {
        int result=0;
        for(int i=1;i< prices.length;i++){
            if(prices[i]>prices[i-1]){
                result+= prices[i]-prices[i-1];
            }
        }
        return result;
    }
}

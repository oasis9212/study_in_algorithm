package stu_20241028;

import java.util.*;

public class leetcode_2944 {
    public static void main(String[] args) {
        int[] prices = {26, 18, 6, 12, 49, 7, 45, 45};
        int[] dp = new int[prices.length];
        Arrays.fill(dp, Integer.MAX_VALUE);  // int 0 배열 초기화를 하던 전부 맥스 값을해서 하던 시간 차이는 없다.
        dp[0] = prices[0];
        dp[1] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 1 절반이 넘어갔다면  dp의 맨마지막은 결정된상태이다.
            // 절반 넘어 갈때 그때 한번 로직을 돌려 맨마지막 값과 배열 idx 중에서 idx 최소로 값이 같을걸 찾아보자

            if(i> prices.length/2 && dp[i-1]+prices[i]>dp[prices.length-1]){
                continue;
            }
            setdp(prices, dp, i);
        }


    }

    // 범위마다 전부 돌아야하기 때문에 확실히 느리다.
    private static void setdp(int[] prices, int[] dp, int idx) {

        int range = Math.min(idx * 2 + 1, prices.length - 1);
        // 해당 dp의 값이 결정이 되면
        // idx*2 의 값들도 전부 해당 dp[idx]의 값으로 결정이 된다. (최소값으로)
        // 다만 빠르게 할라면 어떻게 해야할까.
        for (int i = idx; i <= range; i++) {
            dp[i] = Math.min(dp[idx - 1] + prices[idx], dp[i]);
        }
    }
}

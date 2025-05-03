package stu_20250414;

import java.util.*;

public class leetcode_1833 {
    public static void main(String[] args) {
        // System.out.println(sol_1833(new int[]{1,3,2,4,1},7));
        System.out.println(sol_1833(new int[]{10,6,8,7,7,8}, 5));

    }

    private static int sol_1833(int[] costs, int coins) {

        int max = 0;
        HashSet<Integer> se = new HashSet<>();  // Set 타입 속성이지만 정렬이되는
        HashMap<Integer, Integer> hs = new HashMap<>(); // 해당 값이 존재.
        for (int i = 0; i < costs.length; i++) {
            if (coins > costs[i]) {
                if (se.add(costs[i])) {
                    hs.put(costs[i], 1);
                } else {
                    hs.put(costs[i], hs.get(costs[i]) + 1);
                }
            }
        }

        for (Integer i: se){
           int count= hs.get(i);
           if(coins-count*i>0){
               coins-=count*i;
               max+=count;
           }else{
              max+=coins/=i;
           }
        }

        return max;
    }


}

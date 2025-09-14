package stu_20250831;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2178 {

    public static void main(String[] args) {

        System.out.println(sol_2178(12));
    }

    private static List<Long> sol_2178(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return list;
        }
        long sum = 0;
        long cur = 2;


        while (sum + cur <= finalSum) {
            list.add(cur);
            sum += cur;
            cur += 2;
        }

        long remain= finalSum-sum;
        if(remain>0){
            list.set(list.size() -1, list.get(list.size()-1) +remain );
        }


        return list;
    }
}

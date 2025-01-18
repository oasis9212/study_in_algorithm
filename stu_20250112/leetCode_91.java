package stu_20250112;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode_91 {
    public static void main(String[] args) {
        System.out.println(sol_91("1123"));
        // 1234
    }

    private static int sol_91(String s) {

        if(s.charAt(0)=='0' || s.length()==0){
            return 0;
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;    // 빈 문자열
        dp[1]=1;   // idx 값은 해당 위치 (1번은 s.chatAt(0) 에 해당) 해당 숫자를 만들수 있는 것은 1가지.


        int num=0;
        for (int i = 2; i < dp.length; i++) {

            num = Integer.parseInt(s.substring(i-2,i));
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            if(num>=10 && num <= 26){
                dp[i]+=dp[i-2];
            }

        }





        return dp[dp.length-1];
    }
}

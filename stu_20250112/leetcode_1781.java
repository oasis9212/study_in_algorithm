package stu_20250112;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class leetcode_1781 {
    public static void main(String[] args) {
        
        System.out.println(sol_1781("aabcb"));

    }

    private static int sol_1781(String s) {
      int total=0;

        for (int i = 0; i < s.length(); i++) {
            int[] many=new int[26];
            for (int j = i; j < s.length(); j++) {
                char c= s.charAt(j);
                many[c-'a']++;
                int maxnum=0;
                int minnum=Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if(many[k]>0){
                        minnum=Math.min(minnum,many[k]);
                        maxnum=Math.max(maxnum,many[k]);
                    }
                }
                total+=maxnum-minnum;
            }
        }

        return total;
    }




}

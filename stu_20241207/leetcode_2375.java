package stu_20241207;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_2375 {
    public static void main(String[] args) {
        System.out.println(sol_leetcode_2375("IIIDIDDD"));
        System.out.println(sol_leetcode_2375("DDD"));

    }

    private static String sol_leetcode_2375(String pattern) {
        boolean[] used = new boolean[pattern.length() + 1];
        StringBuffer sb = new StringBuffer();
        int num = pattern.length()+1;  // 우선. ..,

        for (int i = pattern.length(); i >0;) {
            if(pattern.charAt(i-1)=='D'){
                int count=0;
                while (i!=0  && pattern.charAt(i-1)=='D'){
                    count++;
                    i--;
                }
                for(int k=count;k>0;k--){
                    used[num-k-1]=true;
                    sb.append(num-k);
                }
            }else{
                sb.append(num);
                used[num-1]=true;
                for (int j = num; j >= 0; j--) {
                    if(!used[j-1]){
                        num=j;
                        break;
                    }
                }
                i--;
            }

        }
        sb.append(num);

        return sb.reverse().toString();
    }
}

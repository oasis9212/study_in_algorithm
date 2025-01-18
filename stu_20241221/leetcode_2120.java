package stu_20241221;

import java.util.Arrays;

public class leetcode_2120 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_2120(3, new int[]{0, 1}, "RRDDLU")));
    }

    private static int[] sol_2120(int n, int[] startPos , String s) {
        int[] result= new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int[] startPosloc=startPos.clone();
            int count=0;
           for (int j = i; j < s.length(); j++) {
                switch (s.charAt(j)){
                    case 'R':
                        startPosloc[1]++;
                        break;
                    case 'L':
                        startPosloc[1]--;
                        break;
                    case 'D':
                        startPosloc[0]++;
                        break;
                    case 'U':
                        startPosloc[0]--;
                        break;
                    default:
                        break;
                }
                if(startPosloc[0]>=0 && startPosloc[0]<n && startPosloc[1]>=0 && startPosloc[1]<n ){
                    count++;
                }else{
                    break;
                }
            }
            result[i]=count;
        }




        return result;
    }


}

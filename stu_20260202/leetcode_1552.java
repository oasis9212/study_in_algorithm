package stu_20260202;

import java.util.Arrays;

public class leetcode_1552 {
    public static void main(String[] args) {
        System.out.println(sol_1552(new int[]{1,2,3,4,7},3));
    }

    private static int sol_1552(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; // 최소 거리
        int right = position[position.length - 1] - position[0];
        int answer = 0;

        while (left<=right){
            int mid= (left+right) /2;

            if(canplace(position,m,mid)){
                answer=mid;
                left=mid+1;
            }else{
                right= mid-1;
            }
        }
        return answer;

    }

    private static boolean canplace(int[] position, int m, int mid) {
        int count=1;
        int last=position[0];
        for (int i = 0; i < position.length; i++) {
            if(position[i] - last >= mid){
                count++;
                last=position[i];
            }
        }
        return count>=m;


    }
}

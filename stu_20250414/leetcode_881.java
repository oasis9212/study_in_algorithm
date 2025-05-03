package stu_20250414;

import java.util.Arrays;

public class leetcode_881 {
    public static void main(String[] args) {
        System.out.println(sol_881(new int[]{1,2},3));
        System.out.println(sol_881(new int[]{3,2,2,1},3));


    }

    private static int sol_881(int[] people , int limit) {

        Arrays.sort(people);
        int start=0;
        int end= people.length-1;
        int count=0;    // 보트 갯수
        while (start<end){
            if(people[start]+people[end]<=limit){
                count++;
                start++;    // 맞다면 2개 탈수 있다.
                end--;      //
            }else{
                end--;      // 초과할경우 한사람만 탈수 있다.
                count++;
            }
        }
        if(start==end){
            count++;
        }


        return count;
    }
}

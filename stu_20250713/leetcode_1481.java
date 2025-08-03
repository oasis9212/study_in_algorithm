package stu_20250713;

import java.util.*;

public class leetcode_1481 {

    public static void main(String[] args) {

        System.out.println(sol_1481(new int[]{4,3,1,1,3,3,2}, 3));
    }

    private static int sol_1481(int[] arr , int k) {
        HashMap<Integer,Integer> hs= new HashMap<>();

        for (int num: arr) {
            hs.put(num,hs.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hs.entrySet());
        list.sort(Map.Entry.comparingByValue());

        int count= list.size();

        for (Map.Entry<Integer, Integer> entry : list) {
           if(k-entry.getValue()>=0){
               k-=entry.getValue();
               count--;
           }else{
               break;
           }

        }

        return count;
    }

}

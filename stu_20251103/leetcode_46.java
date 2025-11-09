package stu_20251103;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {
    public static void main(String[] args) {

        System.out.println(sol_46(new int[]{1,2}));
        
    }

    private static List<List<Integer>> sol_46(int[] nums) {

        List<List<Integer>> insertlist = new ArrayList<>();

        List<Integer> list =new ArrayList<>();
        boolean[] used= new boolean[nums.length];

        backTrace_46(used,nums,insertlist,list);
        return insertlist;

    }

    private static void backTrace_46(boolean[] used,int[] nums, List<List<Integer>> insertlist, List<Integer> list) {
        if(list.size()==nums.length){
            insertlist.add(list.stream().toList());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i]=true;
            backTrace_46(used, nums, insertlist, list);
            list.remove(list.size()-1);
            used[i]=false;
        }

    }
}

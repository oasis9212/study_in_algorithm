package stu_20260329;

import java.util.Stack;

public class leetcode_946 {
    public static void main(String[] args) {
        System.out.println(sol_946(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }

    private static boolean sol_946(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();

        int popidx=0;

        for(int val: pushed){
            st.add(val);
            while(!st.empty() && st.peek() == popped[popidx]){
                st.pop();
                popidx++;
            }
        }

        return st.empty();
    }
}

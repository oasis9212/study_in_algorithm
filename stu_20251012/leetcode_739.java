package stu_20251012;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_739 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sol_739(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(sol_739(new int[]{30,40,50,60})));

    }

    private static int[] sol_739(int[] temperatures) {
        int n= temperatures.length;
        int[] res= new int[temperatures.length];
        Stack<Integer> st=  new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int previdx= st.pop();
                res[previdx] = i - previdx;
            }
            st.push(i);
        }
        return res;
    }
}


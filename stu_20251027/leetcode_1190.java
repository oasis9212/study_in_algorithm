package stu_20251027;

import java.util.Stack;

public class leetcode_1190 {
    public static void main(String[] args) {
        // System.out.println(sol_1190("(u(love)i)"));
        System.out.println(sol_1190("(ed(et(oc))el)"));
    }


    private static String sol_1190(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuffer sb = new StringBuffer();
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                for (char ch : sb.toString().toCharArray()) {
                    st.add(ch);
                }
            } else {
                st.add(s.charAt(i));
            }
        }


        StringBuffer result = new StringBuffer();
        for (char c : st) result.append(c);
        return result.toString();
    }
}

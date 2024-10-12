package stu_20241006;

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        String s="(())()";
       boolean Tf= stack_sol(s);
        
    }

    private static boolean stack_sol(String s) {
        boolean answer = true;
        Stack<Character> st= new Stack<>();


        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.add(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(st.empty()){
                    return false;
                }else{
                    st.pop();
                }

            }
        }

        if(!st.isEmpty()){
            return false;
        }

        return answer;
    }

}

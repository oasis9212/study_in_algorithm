package stu_20241201;

import java.util.*;

public class leetcode_1249 {
    public static void main(String[] args) {
        String s = "lee' 't(c)o)de)";

        char[] ary = s.toCharArray();  // 배열 따로 만들고
        Stack<Integer> st= new Stack<>();

        for (int i = 0; i < ary.length; i++) {

            if(ary[i]=='('){
                st.add(i); // 배열 위치 스택 집어넣고
                ary[i]=' ';
            }
            else if( ary[i]==')'){
                if(!st.isEmpty()){
                    ary[st.pop()]= '(';
                }else{
                    ary[i]=' ';
                }
            }
        }  // 끝

        // 스택 남을 경우
        // 이미 빈칸 처리 했기 때문에 없는 거나 마찬가지라서

        System.out.println(new String(ary).replaceAll(" ",""));




    }


}

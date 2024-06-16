package stu_20240615;

import java.util.HashSet;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String s="asoiidjioasd";

        int dd= mysol(s);
    }

    private static int mysol(String s) {

        int len=0;
        HashSet<Character> set= new HashSet<Character>();
        String d=""; // 현재 텍스트 상태 알아보기. 중복된 글자 발견하면 그 글자뒤로 잘라버리는것

        for(int i=0;i<s.length();i++) {

            if(set.contains(s.charAt(i))) {
                if(len<set.size()) {
                    len=set.size();
                }//기록 갱신용

                int loc=d.indexOf(s.charAt(i));
                for(int k=0;k<loc;k++) {
                    set.remove(d.charAt(k));
                }// 전글자 삭제.

                d=d.substring(loc+1); // 전글자 다 잘라내기.
                set.add(s.charAt(i));
                d+=s.charAt(i);

            }else {
                set.add(s.charAt(i));
                d+=s.charAt(i);
            }

        }

        if(len<set.size()) {
            len=set.size();
        }
        return len;

    }


}

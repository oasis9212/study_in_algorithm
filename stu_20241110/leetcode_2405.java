package stu_20241110;

import java.util.HashSet;
import java.util.Set;

public class leetcode_2405 {
    public static void main(String[] args) {
        String s="ssssss";

        int count =0;
        Set<Character> set= new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!set.add(s.charAt(i))){
                set.clear();
                set.add(s.charAt(i));
                count++;
            }
        }
        if(!set.isEmpty()){
            count++;
        }

        System.out.println(count);






    }
}

package stu_20250817;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetCode_1930 {
    public static void main(String[] args) {
        System.out.println(sol_1930("aabca"));
    }
//aabcabc
    private static int sol_1930(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);


        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        int result = 0;

        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && first[c] < last[c]) {
                Set<Character> mid = new HashSet<>();
                for (int i = first[c] + 1; i < last[c]; i++) {
                    mid.add(s.charAt(i));
                }
                result += mid.size();
            }
        }
        return result;
    }
}

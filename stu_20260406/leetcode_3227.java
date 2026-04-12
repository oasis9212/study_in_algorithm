package stu_20260406;

public class leetcode_3227 {
    public static void main(String[] args) {
        System.out.println(sol_2337("leetcoder"));
    }

    private static boolean sol_2337(String s) {

        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0) {
                return true;
            }
        }
        return false;

    }
}

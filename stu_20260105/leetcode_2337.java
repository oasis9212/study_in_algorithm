package stu_20260105;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_2337 {
    public static void main(String[] args) {
        System.out.println(sol_237("__L_R__R_", "_L_____RR"));
    }

    private static boolean sol_237(String start, String target) {
        int s = 0;
        int t = 0;
        int len = target.length();

        while (s < len || t < len) {

            while (s < len && start.charAt(s) == '_') s++;
            while (t < len && target.charAt(t) == '_') t++;

            if (s == len || t == len) return s == t;

            char c = start.charAt(s);

            if (c != target.charAt(t)) return false;

            if (c == 'L' && s < t) return false;
            if (c == 'R' && s > t) return false;

            s++;
            t++;
        }
        return true;


    }
}

package stu_20250519;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class leetCode_451 {

    public static void main(String[] args) {

        System.out.println(sol_451("tree"));

    }

    private static String sol_451(String s) {

        HashMap<Character, Integer> hs = new HashMap<>();
        PriorityQueue<alpha> qu = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
        }
        hs.forEach((k, v) -> qu.add(new alpha(k, v)));
        StringBuffer sb = new StringBuffer();
        while (!qu.isEmpty()) {
            alpha x = qu.poll();
            for (int i = 0; i < x.count; i++) {
                sb.append(x.c);
            }
        }

        return sb.toString();
    }
}


class alpha implements Comparable<alpha> {

    char c;
    int count;

    public alpha(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public int compareTo(alpha o) {
        return o.count - this.count;
    }
}
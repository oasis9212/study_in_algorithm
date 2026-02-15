package stu_20260208;

import java.util.*;

public class leetcode_752 {
    public static void main(String[] args) {
        System.out.println(sol_752(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    private static int sol_752(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if (dead.contains(start)) return -1;
        Queue<String> qu = new LinkedList<>();
        visited.add(start);
        qu.add(start);

        int step = 0;

        while (!qu.isEmpty()) {

            int size = qu.size();

            for (int s = 0; s < size; s++) {
                String current = qu.poll();
                if (current.equals(target)) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {
                    char[] ary = current.toCharArray();

                    ary[i] = ary[i] == '9' ? '0' : (char) (ary[i] + 1);
                    String up = new String(ary);
                    if (!dead.contains(up) && !visited.contains(up)) {
                        qu.add(up);
                        visited.add(up);
                    }

                    ary = current.toCharArray();
                    ary[i] = ary[i] == '0' ? '9' : (char) (ary[i] - 1);
                    String down = new String(ary);
                    if (!dead.contains(down) && !visited.contains(down)) {
                        qu.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}

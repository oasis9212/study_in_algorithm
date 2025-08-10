package stu_20250804;

import java.util.*;

public class leetcode_621 {
    public static void main(String[] args) {

        System.out.println(sol_621(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
          System.out.println(sol_621(new char[]{'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'}, 1));

    }

    private static int sol_621(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<Character> s = new ArrayList<>(map.keySet());
        s.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        PriorityQueue<task> pq = new PriorityQueue<task>();

        int idx = 1;
        for (Character m : s) {
            task t = new task(m, map.get(m), 0);  // 전부 후보군이다.
            pq.add(t);
        }
        int len = 0;  // 주기 라고 생각해보자..,
        Queue<task> cooltime= new LinkedList<>();

        while (!pq.isEmpty() || !cooltime.isEmpty()) {
            len++;
            if(!cooltime.isEmpty() &&  cooltime.peek().n==len){
                pq.add(cooltime.poll());
            }
            if(!pq.isEmpty()){
                task t= pq.poll();
                t.count--;
                t.n=len+n+1;
                if(t.count>0){
                    cooltime.add(t);
                }
            }
            // A B X A B X A B
            // A B A C A D A G

        }
        return len;
    }


    static class task implements Comparable<task> {

        char t;  // 알바벳
        int count; // 갯수
        int n; // 쿨타임

        task(char t, int count, int n) {
            this.t = t;
            this.count = count;
            this.n = n;
        }

        @Override
        public int compareTo(task o) {
            return  o.count - this.count;
        }
    }
}

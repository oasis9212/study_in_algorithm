package stu_20250914;

import java.util.*;

public class leetcode_743 {
    public static void main(String[] args) {

        System.out.println(sol_743(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));

    }

    private static int sol_743(int[][] times , int n, int k) {

        List<List<Node_743>> graph= new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] t : times){
            graph.get(t[0]).add(new Node_743(t[1],t[2]));
        }

        int[] dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k]=0;

        PriorityQueue<Node_743> pq= new PriorityQueue<>(Comparator.comparing(a->a.time));

        pq.offer(new Node_743(k,0));

        while (!pq.isEmpty()){
            Node_743 cur= pq.poll();
            if(cur.time > dist[cur.to]) continue;

            for (Node_743 next: graph.get(cur.to)){
                int newTime= cur.time + next.time;
                if(newTime < dist[next.to]){
                    dist[next.to] = newTime;
                    pq.offer(new Node_743(next.to,newTime));
                }
            }

        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;





    }
}


class Node_743{
    int to, time;
    public Node_743(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
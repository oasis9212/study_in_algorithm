package stu_20240822;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 배달_129783 {
    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;


        List<List<node_129783>> graph = new ArrayList<>();
        // 임의 0 을 넣어서 계산에 용이하게.
        int[] Nrange = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            Nrange[i] = 500_001;
        }
        Nrange[1] = 0;

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int range = road[i][2];
            graph.get(a).add(new node_129783(b, range));
            graph.get(b).add(new node_129783(a, range));
        }

        PriorityQueue<node_129783> pq = new PriorityQueue<>();
        pq.offer(new node_129783(1, 0));

        while (!pq.isEmpty()) {
            node_129783 n = pq.poll();
            int Nnum = n.num;
            int Ndist = n.dist;

            if (Ndist > Nrange[Nnum]) {
                continue;
            }

            for (node_129783 d : graph.get(Nnum)) {
                int ABrnage = d.dist + n.dist;
                if (ABrnage < Nrange[d.num]) {
                    Nrange[d.num] = ABrnage;
                    pq.offer(new node_129783(d.num, ABrnage));
                }
            }
        }
        int result = 0;
        for (int count : Nrange) {
            if (count <= K) result++;
        }


    }
}

class node_129783 implements Comparable<node_129783> {
    int num;
    int dist;

    public node_129783(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    public int compareTo(node_129783 o) {
        return o.dist - this.dist;
    }
}
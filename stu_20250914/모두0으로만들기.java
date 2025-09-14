package stu_20250914;

import java.util.*;

public class 모두0으로만들기 {

    public static void main(String[] args) {
        System.out.println(sol_모두(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }

    private static long sol_모두(int[] a, int[][] edges) {
        long[] longs_a=new long[a.length];
        ArrayList<Integer>[] list = new ArrayList[a.length];
        boolean[] visited=new boolean[a.length];

        long sum =0 ;
        for(int i=0;i< a.length;i++){
            sum+=a[i];
            longs_a[i] = a[i];
            list[i]=new ArrayList<>();
        }
        if(sum !=0) return -1;

        int[] indegree = new int[a.length];
        for (int i=0;i< edges.length;i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);

            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }

        Queue<Integer> qu= new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==1) qu.add(i);
        }
        long result=0;

        while (!qu.isEmpty()){
            int current = qu.poll();
            visited[current]= true;

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                if(!visited[next]){
                    indegree[next]--;
                    longs_a[next] += longs_a[current];
                    result+= Math.abs(longs_a[current]);
                    longs_a[current] =0;
                    if(indegree[next] ==1 ) qu.add(next);
                }
            }

        }
        return result;
    }
}

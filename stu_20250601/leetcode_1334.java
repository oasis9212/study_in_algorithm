package stu_20250601;

import java.util.*;

public class leetcode_1334 {

    public static void main(String[] args) {

        System.out.println(sol_1334(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(sol_1334(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, 2));
        System.out.println(sol_1334(6, new int[][]{{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, 20));
    }

    private static int sol_1334(int n, int[][] edges, int distanceThreshold) {
        // 1. 최단 거리 배열 초기화
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2); // 오버플로 방지
            dis[i][i] = 0;
        }

        // 2. 간선 정보 반영
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            dis[from][to] = weight;
            dis[to][from] = weight;
        }

        // 3. 플로이드 워셜로 모든 쌍 최단 거리 계산
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        // 4. 각 도시마다 reachable city 수 계산
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dis[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            ary[i] = count;
        }

        System.out.println(Arrays.toString(ary)); // 디버깅 출력

        // 5. 가장 적게 도달 가능한 도시 중, 번호가 가장 큰 도시 찾기
        int min = Integer.MAX_VALUE;
        int city = -1;
        for (int i = 0; i < n; i++) {
            if (ary[i] <= min) {
                min = ary[i];
                city = i;
            }
        }

        return city;
    }

    private static int dfs_1334(List<List<Integer>> list, int[][] dis, int distanceThreshold, int node,boolean[] visited) {
        List<Integer> s=list.get(node);
        int c =1;
        for (int i = 0; i < s.size(); i++) {
            if(!visited[s.get(i)] &&  distanceThreshold-dis[node][s.get(i)]>=0){
                visited[s.get(i)]=true;
                int disnum=dis[node][s.get(i)];
                c+=dfs_1334(list,dis,distanceThreshold-disnum,s.get(i),visited);
            }

        }

        return c;
    }


}

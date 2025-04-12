package stu_20250406;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class leetcode_802 {
    static boolean[] connected;
    private static Boolean[] memo;        // 안전 여부 캐시 (null: 미방문, true/false: 결과)

    public static void main(String[] args) {

           System.out.println(sol_802(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
      //  System.out.println(sol_802(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
    }

    private static List<Integer> sol_802(int[][] graph) {
        List<List<Integer>> node = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            node.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                node.get(i).add(graph[i][j]);
            }
        }
        // 노드 생성


        connected = new boolean[graph.length];
        memo = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isSafe(i, node, new HashSet<>())) {
                connected[i] = true;
            }

        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < connected.length; i++) {
            if (!connected[i]) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSafe(int idx, List<List<Integer>> node, HashSet<Integer> path) {
        if (memo[idx] != null) return memo[idx]; // 이미 검문 통과했을 경우 TF 처리

        if (!path.add(idx)) {
            memo[idx] = false;
            return false;
        }

        for (int next : node.get(idx)) {
            if (!isSafe(next, node, new HashSet<>(path))) {  //한번이라도 false 났을 경우 해당 검색했던 노드들은 순환된다는 뜻으로 전부false 처리
                memo[idx] = false;
                return false;
            }
        }

        memo[idx] = true;  // 반대로 노드를 돌면서 맨마지막(종단점)이 있을 경우는 해당 노드들은 터미널노드이다.
        return true;
    }


}

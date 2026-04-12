package stu_20260406;

import java.util.ArrayList;
import java.util.List;

public class leetcode_797 {
    public static void main(String[] args) {
        System.out.println(sol_797(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    private static List<List<Integer>> sol_797(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, result, list);

        return result;

    }

    private static void dfs(int loc, int[][] graph, List<List<Integer>> result, List<Integer> list) {
        if (loc == graph.length - 1) {
            result.add(new ArrayList<>(list));
        }

        for (int i : graph[loc]) {
            list.add(i);
            dfs(i,graph,result,list);
            list.remove(list.size()-1);
        }
    }
}

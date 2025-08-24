package stu_20250817;

import java.util.*;

public class leetcode_638 {
    public static void main(String[] args) {

        System.out.println(sol_638(new int[]{2, 5}, new int[][]{{3, 0, 5}, {1, 2, 10}}, new int[]{3, 2}));
        System.out.println(sol_638(new int[]{2, 3, 4}, new int[][]{{1, 1, 0, 4}, {2, 2, 1, 9}}, new int[]{1, 2, 1}));
        System.out.println(sol_638(new int[]{9, 9}, new int[][]{{1, 1, 1}}, new int[]{2, 2}));
    }

    private static int sol_638(int[] priced, int[][] speciald, int[] needsd) {

        List<Integer> price = new ArrayList<>();
        for (int p : priced) {
            price.add(p);
        }

        // special 변환
        List<List<Integer>> special = new ArrayList<>();
        for (int[] sp : speciald) {
            List<Integer> offer = new ArrayList<>();
            for (int v : sp) {
                offer.add(v);
            }
            special.add(offer);
        }

        // needs 변환
        List<Integer> needs = new ArrayList<>();
        for (int n : needsd) {
            needs.add(n);
        }

        return dfs(price, special, needs);
    }

    private static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }
        Queue<int[]> qu = new LinkedList<>();
        int[] val = new int[needs.size() + 1];
        for (int i = 0; i < needs.size(); i++) {
            val[i] = needs.get(i);
        }
        val[needs.size()] = minCost;
        qu.add(val);
        List<int[]> end = new ArrayList<>();
        while (!qu.isEmpty()) {
            boolean theEnd = false;
            val = qu.poll();
            loop:
            for (List<Integer> offer : special) {
                int[] v = new int[needs.size() + 1];
                v[needs.size()] = val[needs.size()];
                for (int i = 0; i < val.length - 1; i++) {
                    if (val[i] < offer.get(i)) {
                        continue loop;
                    }
                    v[needs.size()] -= offer.get(i) * price.get(i);
                    v[i] = val[i] - offer.get(i);
                }
                v[needs.size()] += offer.get(offer.size() - 1);
                if (val[needs.size()] > v[needs.size()]) {
                    theEnd = true;
                    qu.add(v);
                }
            }
            if (!theEnd) {
                end.add(val);
            }
        }
        for (int i = 0; i < end.size(); i++) {
            minCost = Math.min(minCost, end.get(i)[needs.size()]);
        }
        return minCost;
    }
}

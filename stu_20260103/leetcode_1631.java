package stu_20260103;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_1631 {
    public static void main(String[] args) {
        System.out.println(sol_1631(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    private static int sol_1631(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int r = cur[1];
            int c = cur[2];


            if (r == rows - 1 && c == cols - 1) {
                return effort;
            }

            // 이미 더 좋은 경로가 있으면 스킵
            if (effort > dist[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;

                int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                int nextEffort = Math.max(effort, diff);

                if (nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.offer(new int[]{nextEffort, nr, nc});
                }
            }
        }

        return 0; 
    }
}

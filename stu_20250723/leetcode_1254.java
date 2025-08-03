package stu_20250723;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1254 {

    public static void main(String[] args) {
        System.out.println(sol_1254(new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}));
    }

    private static int sol_1254(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && dfs_1254(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean dfs_1254(int[][] grid, int selo, int galo) {
        int[][] loc = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> qu = new LinkedList<>();
        boolean isClosed = true;

        qu.add(new int[]{selo, galo});
        grid[selo][galo] = 2;  // 방문처리

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : loc) {
                int nx = x + d[0];
                int ny = y + d[1];

                // 경계 닿음 → 닫힌 섬 아님
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                    isClosed = false;
                    continue;
                }

                if (grid[nx][ny] == 0) {
                    grid[nx][ny] = 2;
                    qu.add(new int[]{nx, ny});
                }
            }
        }

        return isClosed;
    }
}

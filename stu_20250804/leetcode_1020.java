package stu_20250804;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1020 {
    public static void main(String[] args) {
        System.out.println(sol_1020(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
        System.out.println(sol_1020(new int[][]{{0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0,0,0,0}}));

    }

    private static int sol_1020(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count += changeZero(grid, j, i);
                }

            }
        }
        return count;
    }

    private static int changeZero(int[][] grid, int x, int y) {
        boolean theEnd = false;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{y, x});
        grid[y][x] = 0;
        int count = 0;
        int[][] loc = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            int cx = cur[1];
            int cy = cur[0];
            count++;


            if (cy == 0 || cy == grid.length - 1 || cx == 0 || cx == grid[0].length - 1) {
                theEnd = true;
            }

            for (int[] d : loc) {
                int ny = cy + d[0];
                int nx = cx + d[1];

                if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length && grid[ny][nx] == 1) {
                    qu.add(new int[]{ny, nx});
                    grid[ny][nx] = 0;
                }
            }
        }

        return theEnd ? 0 : count;
    }
}

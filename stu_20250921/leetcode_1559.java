package stu_20250921;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetcode_1559 {

    public static void main(String[] args) {
        System.out.println(sol_1559(new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}}));
        System.out.println(sol_1559(new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}}));

    }

    private static boolean sol_1559(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, visited, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, int x, int y, int px, int py,
                               boolean[][] visited, char c) {
        if (visited[x][y]) return true;
        visited[x][y] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
            if (grid[nx][ny] != c) continue;
            if (nx == px && ny == py) continue; // 직전 노드는 무시

            if (dfs(grid, nx, ny, x, y, visited, c)) {
                return true;
            }
        }
        return false;
    }
}

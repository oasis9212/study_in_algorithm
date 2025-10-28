package stu_20251027;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_695 {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}
//                , {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
//                , {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}
//                , {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}
//                , {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid = new int[][]
                { {1,1,0,0,0}
                , {1,1,0,0,0}
                , {0,0,0,1,1}
                , {0,0,0,1,1}
                };

        System.out.println(sol_695(grid));


    }

    private static int sol_695(int[][] grid) {

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }

        return res;
    }

    private static int bfs(int[][] grid, int i, int j) {
        int count = 1;
        grid[i][j]=0;
        int[][] loc = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{i, j});
        while (!qu.isEmpty()) {
            int[] val = qu.poll();
            int y = val[0];
            int x = val[1];

            for (int[] l : loc) {
                if (y + l[0] >= 0 && y + l[0] < grid.length && x + l[1] >= 0 && x + l[1] < grid[0].length && grid[y + l[0]][x + l[1]] == 1) {
                    grid[y + l[0]][x + l[1]] = 0;
                    count++;
                    qu.add(new int[]{y + l[0], x + l[1]});
                }
            }
        }
        return count;
    }
}

package stu_20250810;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_3619 {
    public static void main(String[] args) {

        System.out.println(sol_3619(new int[][]{{0,2,1,0,0}, {0,5,0,0,5}, {0,0,1,0,0}, {0,1,4,7,0},{0,2,0,0,8}}, 5));
    }

    private static int sol_3619(int[][] grid, int k) {
        int count =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    int landsum = landsum(grid, i, j);
                    if(landsum%k==0){
                        count++;
                    }
                }

            }
        }
        return count;
    }

    private static int landsum(int[][] grid, int y, int x) {
        int sum=0;

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{y, x});
        sum+=grid[y][x];
        grid[y][x]=0;

        int[][] loc = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            int cy = cur[0];
            int cx = cur[1];


            for (int[] d : loc) {
                int ny = cy + d[0];
                int nx = cx + d[1];

                if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length && grid[ny][nx] > 0) {
                    qu.add(new int[]{ny, nx});
                    sum+=grid[ny][nx];
                    grid[ny][nx] = 0;
                }
            }
        }
        return sum;
    }
}

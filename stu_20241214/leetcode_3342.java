package stu_20241214;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_3342 {
    public static void main(String[] args) {
//        System.out.println(leetcode_3342_sol(new int[][]{{0,1},{1,2}}));
        System.out.println(leetcode_3342_sol(new int[][]{{25,44},{4,2}}));
//        System.out.println(leetcode_3342_sol(new int[][]{{0,0,0,0},{0,0,0,0}}));
        //       System.out.println(leetcode_3342_sol(new int[][]{{0,43,20},{94,88,56},{23,21,22}}));
        System.out.println(leetcode_3342_sol(new int[][]{{38, 87, 68, 34, 32, 8}
                , {3, 29, 39, 73, 86, 10}}));

        // [[25,44],[4,2]] 여기에서 틀렸는데 무조건 28 아닌가 답은 7
    }

    private static int leetcode_3342_sol(int[][] moveTime) {
        int[][] minTime = new int[moveTime.length][moveTime[0].length];
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        minTime[0][0] = 0;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int OneTwo = cur[2];


            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 체크
                if (ny < 0 || ny >= moveTime.length || nx < 0 || nx >= moveTime[0].length) continue;


                int stepTime = Math.max(moveTime[ny][nx],minTime[y][x]) +OneTwo;



                if (!visited[ny][nx]) {
                    minTime[ny][nx] = stepTime;
                    visited[ny][nx]=true;
                    queue.add(new int[]{ny, nx, OneTwo == 1 ? 2 : 1});
                }else if(visited[ny][nx] && stepTime< minTime[ny][nx]){
                    minTime[ny][nx] = stepTime;
                    queue.add(new int[]{ny, nx, OneTwo == 1 ? 2 : 1});
                }
            }
        }
        return minTime[moveTime.length - 1][moveTime[0].length - 1] ;
    }



}

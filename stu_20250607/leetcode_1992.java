package stu_20250607;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode_1992 {

    public static void main(String[] args) {
       // System.out.println(Arrays.deepToString(sol_1992(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));
        System.out.println(Arrays.deepToString(sol_1992(new int[][]{{1,1,0,0,0,1},{1,1,0,0,0,0}})));

    }

    private static int[][] sol_1992(int[][] land) {

        boolean[][] visited = new boolean[land.length][land[0].length];

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] a = bfs(land, i, j, visited);
                    list.add(a);
                }
            }
        }

        int[][] result = list.toArray(new int[list.size()][]);
        return result;
    }

    private static int[] bfs(int[][] land, int i, int j, boolean[][] visited) {
        int[] res = new int[4];
        res[0] = i;
        res[1] = j;
        res[2]= i;
        res[3]= j;
        visited[i][j] = true;
        int[] val = new int[2];
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{i, j});

        int[][] directions = {{1, 0} ,{0, 1}}; // 상하좌우
        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int galo = cur[0];
            int selo = cur[1];
            res[2] = Math.max(res[2], galo);
            res[3] = Math.max(res[3], selo);

           for (int [] d : directions){
               int nr = galo + d[0];
               int nc = selo + d[1];
               if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length) {
                   if (land[nr][nc] == 1 && !visited[nr][nc]) {
                       visited[nr][nc] = true;
                       st.push(new int[]{nr, nc});
                   }
               }
           }


        }


        return res;
    }
}

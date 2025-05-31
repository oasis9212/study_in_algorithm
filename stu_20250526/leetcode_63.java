package stu_20250526;

import java.util.LinkedList;
import java.util.Queue;


public class leetcode_63 {
    public static void main(String[] args) {
     //   System.out.println(sol_63(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(sol_63(new int[][]{{0,0,0,0}, {0,1,0,0}, {0,0,0,0}}));
    }

    private static int sol_63(int[][] obstacleGrid) {

        if(obstacleGrid[0][0]==1) return 0;
        int[][] pathcase = new int[obstacleGrid.length][obstacleGrid[0].length];
        pathcase[0][0] = 1;
        Queue<int[]> loc = new LinkedList<>();
        loc.add(new int[]{0, 0});


        while (!loc.isEmpty()) {

            int[] l = loc.poll();
            int selo = l[0];
            int galo = l[1];
            if (selo < obstacleGrid.length-1 && obstacleGrid[selo + 1][galo] == 0) {
                pathcase[selo + 1][galo] += pathcase[selo][galo];
                loc.add(new int[]{selo + 1, galo});
            }
            if (galo < obstacleGrid[0].length-1 && obstacleGrid[selo][galo + 1] == 0  ) {
                pathcase[selo][galo + 1] += pathcase[selo][galo];
                loc.add(new int[]{selo, galo + 1});
            }


        }

        return pathcase[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    private static void gobfs(int[][] pathcase, int[][] obstacleGrid, int galo, int selo) {


    }
}

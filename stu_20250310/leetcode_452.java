package stu_20250310;

import java.util.*;

public class leetcode_452 {
    public static void main(String[] args) {

        System.out.println(sol_452(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
       // System.out.println(sol_452(new int[][]{{1,2}, {3,4}, {5,6}, {7,8}}));


    }

    private static int sol_452(int[][] points) {


        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows=1;
        int arrowPos= points[0][1];

        for (int i = 1; i < points.length; i++) {
            if(points[i][0]> arrowPos){

                arrows++;
                arrowPos=points[i][1];
            }
        }
        return  arrows;

    }


}

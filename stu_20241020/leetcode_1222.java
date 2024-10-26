package stu_20241020;

import java.util.ArrayList;
import java.util.List;

public class leetcode_1222 {
    public static void main(String[] args) {
        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};
        boolean[][] flatqueens = flating(queens);  // 평탄화 실패.

        List<List<Integer>> list = new ArrayList<>();
        int[] goloc = {-1, 0, 1};// x, y 기준으로 -방향, 안감, +방향
        for (int i = 0; i < goloc.length; i++) {
            for (int j = 0; j < goloc.length; j++) {
                if (goloc[j] == 0 && goloc[i] == 0) {
                   continue;
                }
                int a = seek(king[0],king[1], goloc[i], goloc[j], flatqueens);
                if (a != 100) {
                    List<Integer> l= new ArrayList<>();
                    l.add(a%8);
                    l.add(a/8);
                    list.add(l);
                }
            }
        }


    }

    private static int seek(int kingx,int kingy, int x, int y, boolean[][] flatqueens) {
        if (y == -1) {
            kingy -= 1;
        } else if (y == 1) {
            kingy += 1;
        }

        if (x == -1) {
            kingx -= 1;
        } else if (x == 1) {
            kingx += 1;
        }
        if(kingx<0 || kingx>=8 || kingy<0 || kingy>=8){
            return 100;
        }

        if(flatqueens[kingx][kingy]){
            return kingx+kingy*8;
        }else{
            return seek(kingx,kingy,x,y,flatqueens);
        }


    }

    private static boolean[][] flating(int[][] queens) {
        boolean[][] qu = new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            qu[queens[i][0]][queens[i][1]] = true;
        }
        return qu;
    }
}

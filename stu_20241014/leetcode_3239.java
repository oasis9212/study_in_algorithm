package stu_20241014;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode_3239 {
    public static void main(String[] args) {
        int[][] grid = {{0,1}, {0,1}, {0, 0}};
       // int[] flat = Arrays.stream(grid).flatMapToInt(Arrays::stream).toArray();
        int xlen = grid[0].length;
        int ylen = grid.length;

        // x 가로 기준 회문으로 변경할수 있게 구조
        // 이중 포문을 하던 평탄화 작업해서 하던 횟수는 동일 할듯?
        int xcount=0;
        for(int i=0;i<ylen;i++){
            for (int k = 0; k < xlen/2; k++) {
                if(grid[i][k]!=grid[i][xlen-k-1]){
                    xcount++;
                }
            }
        }
        // y 기준으로 회문을 변경 할수 있게 구조
        int ycount=0;
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen/2; j++) {
                if(grid[j][i]!=grid[ylen-j-1][i]){
                    ycount++;
                }
            }
        }
        int answer= Math.min(xcount,ycount);


    }
}

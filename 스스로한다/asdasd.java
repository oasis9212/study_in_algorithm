package 스스로한다;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class asdasd {

    public static void main(String[] args) {

        int rows = 5, cols = 6, rStart =1, cStart = 4;
        System.out.println(Arrays.deepToString(sol_885(rows, cols, rStart, cStart)));

        // 결과 출력

    }

    private static int[][] sol_885(int rows, int cols, int rStart, int cStart) {
        int[][] list=new int[rows*cols][2];

        // 방향: 동, 남, 서, 북 (y, x 순서)
        int[][] yx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int enws = 0; // 초기 방향 (동쪽)
        int step = 1; // 초기 이동 거리
        int x = cStart, y = rStart; // 시작 위치
        list[0][0]=rStart;
        list[0][1]=cStart;

        int val=1;

        while (val < rows * cols) {
            // 각 방향으로 이동
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) { // 현재 방향으로 이동
                    y += yx[enws][0]; // y 변화
                    x += yx[enws][1]; // x 변화

                    // 격자 안에 있을 경우에만 추가
                    if (y >= 0 && y < rows && x >= 0 && x < cols) {
                        list[val][0]=y;
                        list[val][1]=x;
                        val++;
                    }
                }
                // 방향 전환 (시계 방향)
                enws = (enws + 1) % 4;
            }

            step++;
        }


        return list;


    }



}

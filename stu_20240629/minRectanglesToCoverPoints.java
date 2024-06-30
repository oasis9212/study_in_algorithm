package stu_20240629;

import java.util.Arrays;

public class minRectanglesToCoverPoints {
    public static void main(String[] args) {
        int[][] points = {{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}};

        int w = 1;
        int ans= sol(points,w);
        int ans2=sol2(points,w);
        System.out.println(ans);
        System.out.println(ans2);
    }

    private static int sol2(int[][] points, int w) {
        Arrays.sort(points,(a, b)->(a[0] - b[0]));
        int result = 1;
        int previous = points[0][0];
        int acc = 0;
        for(int i = 0; i < points.length; i++){
            acc += points[i][0] - previous;
            if(acc > w){
                result++;
                acc = 0;
            }
            previous = points[i][0];
        }
        return result;
    }

    private static int sol(int[][] points, int w) {
        //x 의 대한 좌표만 중요.
        //x 의 중복값도 제거가 필요
        int ans=0;
        int[] xloc =  Arrays.stream(points).mapToInt(x -> x[0]).distinct().sorted().toArray();
        int anchor=xloc[0];  //
        // 두가지 케이스
        // w 초과한 범위의 경우 해당 이전 x 좌표만 사각형을 구성
        // w 같다면 x 를 -1 로 변환 (이미 덮여있기때문에)
        for(int x : xloc){
            if(anchor==-1){
                anchor=x;
            }

            if(x-anchor>w){
                ans++;
                anchor=x;
            }else if(x-anchor==w){
                ans++;
                anchor=-1;
            }
        }
        if(anchor!=-1){ans++;}


        return ans;

    }

}

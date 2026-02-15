package stu_20260208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_808 {
    public static void main(String[] args) {
        System.out.println(sol_808(150));
    }

    private static double sol_808(int n) {
        if(n==0){
            return  0.5;
        }else if(n>=5000){
            return 1;
        }
        int len = (n + 24) / 25;
        if(len<=2){
            return 0.625;
        }
        double[][] ary = new double[len + 1][len + 1];
        // len  [1][1] == A : 25 , B : 25
        // len  [2][2] == A : 50 , B : 50
        // len  [3][2] == A : 75 , B : 50

        ary[0][0] = 0.5;  // 둘다 없다 동점
        for (int i = 1; i < ary[0].length; i++) {  // B  가 가로열이라고 생각하고
         ary[0][i]=1;  // B가  남아 있다
            //      ary[i][0]=0; // A가 남았다.
        }
        //  B가  남아 있다 ?  A 가남아있다 짐   0 0은 동점이니깐 0.5 이다.

        for (int i=1;i<ary.length;i++){
            for (int j = 1; j < ary.length; j++) {
                double total= ary[Math.max(0,i-4)][j] +    // (100,0) 쓰면 해당 좌표에 대한 결과값이 있는것
                              ary[Math.max(0,i-3)][Math.max(0,j-1)] + // (75,25) 쓰면 해당 좌표에 대한 결과값이 있다.
                              ary[Math.max(0,i-2)][Math.max(0,j-2)] +  // (50,50)
                              ary[Math.max(0,i-1)][Math.max(0,j-3)];  // (25,75)
                ary[i][j]=0.25*total;
            }
        }
        // DP 에 대한 정의가 무조건 1차원으로 생각하지말고 2차원으로 생각해야할 요소가 있다.
        System.out.println(Arrays.deepToString(ary));
        return ary[ary.length-1][ary.length-1];
    }
}

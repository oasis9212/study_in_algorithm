package stu_20240615;

public class programmers_42898 {
   // https://school.programmers.co.kr/learn/courses/30/lessons/42898
    public static void main(String[] args) {
        solution(4,3,new int[][]{{2,2}});
    }


    public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int square[][]=new int[n+1][m+1];

        for(int i=0;i<puddles.length;i++) {
            square[puddles[i][1]][puddles[i][0]]=-1;
        }
        square[1][1]=1;

        for(int i=1;i<square.length;i++) {
            for(int k=1;k<square[i].length;k++) {
                if(square[i][k]==-1) {
                    continue;
                }else {
                    if(square[i-1][k]>0) square[i][k]+= square[i-1][k]% mod;
                    if(square[i][k-1]>0) square[i][k]+= square[i][k-1]%mod;

                }
            }
        }



        int answer=square[n][m]%1000000007;
        return answer;
    }
}

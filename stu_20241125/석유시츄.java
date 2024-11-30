package stu_20241125;

import java.util.*;

public class 석유시츄 {
    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        int[] coltotalnum= new int[land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                     gettotal(coltotalnum, land, i, j);
                }
            }
        }


        int max = 0;
        for (int sum : coltotalnum) {
            max = Math.max(max, sum);
        }
        System.out.println(max);


    }

    private static void gettotal(int[] coltotalnum, int[][] land, int y, int x) {

        Set<Integer> set=new HashSet<>();

        int total=0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        Queue<int[]> qu=new LinkedList<>();
        qu.add(new int[]{y,x});
        while (!qu.isEmpty()){
            int[] s= qu.poll();
            int cx=s[1];
            int cy=s[0];
            if (land[cy][cx] == 0) continue;
            land[cy][cx] = 0;
            set.add(cx);
            total += 1;

            for(int i=0;i< 4;i++){
                int ny = cy+ dy[i];
                int nx = cx+ dx[i];

                if(ny>= 0  && ny < land.length && nx >= 0 && nx < land[0].length && land[ny][nx] !=0){
                    qu.add(new int[]{ny,nx});
                }
            }
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            coltotalnum[it.next()]+=total;
        }



    }

}

package stu_20240629;

import java.util.Arrays;

public class countPoints {
    public static void main(String[] args) {
        int[][] points= {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] queries={{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        int[] ans= sol(points, queries);
        System.out.println(Arrays.toString(ans));

    }

    private static int[] sol(int[][] points, int[][] queries) {
        int[] ans =new int[queries.length];
       for(int i=0;i<queries.length;i++){
           int x=queries[i][0];
           int y=queries[i][1];
           int radius =queries[i][2];

           int count=0;

           for(int k=0;k<points.length;k++){
               int Px_len= Math.abs(points[k][0]-x);
               int Py_len= Math.abs(points[k][1]-y);
               if(Px_len==0 || Py_len==0){
                  count = radius >= Px_len + Py_len ? count+1 : count;
               }else{
                   count= Math.pow(Px_len,2) + Math.pow(Py_len,2) <= Math.pow(radius,2)  ? count+1 : count ;
               }
               // 개선된 코드 .
//               int Px_len= points[k][0]-x;
//               int Py_len= points[k][1]-y;
//               if(Px_len*Px_len + Py_len*Py_len <= radius * radius){
//                   count++;
//               }


           }


           ans[i]=count;
       }
        return ans;
    }
}

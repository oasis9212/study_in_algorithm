package stu_20241207;

import java.util.HashSet;
import java.util.Set;

public class 기지국_설치 {

    public static void main(String[] args) {

   //     System.out.println(sol_기지국(11  , new int[]{4, 11},  1));  //3
     //   System.out.println(sol_기지국(16  , new int[]{9},  2));      //3
        System.out.println(sol_기지국(16  , new int[]{9},  2));  //4
//        System.out.println(sol_기지국(5  , new int[]{3},  2));           //0
//        System.out.println(sol_기지국(6  , new int[]{3},  2));           //1
//        System.out.println(sol_기지국(16  , new int[]{1,16},  2));  // 2
//        System.out.println(sol_기지국(6  , new int[]{4},  2));           // 1
//        System.out.println(sol_기지국(11  , new int[]{1,4},  1));           // 2
//        System.out.println(sol_기지국(11  , new int[]{1,5},  1));           // 3
//        System.out.println(sol_기지국(5  , new int[]{1,2,3,4,5},  1));           // 0
//        System.out.println(sol_기지국(200000000   , new int[]{100000000},  5));           // 0


    }

    private static int sol_기지국(int n, int[] stations, int w) {

        int range= w * 2 +1 ;

       // int minstations= n/range +  ( n%range > 0 ? 1 : 0);  // 아무것도 안깔고 최소의 기지국 설치한다면 다음과같이 나옴.
        int minstations=0;
        int setuploc=0;

        for (int i = 0; i < stations.length; i++) {
            if (((stations[i] + w)-setuploc) % range == 0) {  // 최소의 방법으로만 기지국을 깔았는데 하필 있었다.
                minstations+= ((stations[i] + w)-setuploc) / range;

            } else {  // 이미 이상한 곳에 깔았다 ㅡㅡ;;
                if(setuploc>stations[i]){  // 게다가 주파수 영향범위안에 있었다.
                    minstations++;
                }else{
                    minstations+=((stations[i] + w)-setuploc) / range ;
                    if(((stations[i] + w)-setuploc) % range >0){
                        minstations++;
                    }
                }
            }
            setuploc=stations[i] + w ;  // 주파수 영향도 범위
        }
        if(setuploc<n){
           while (n>setuploc){
               setuploc+=range;
               minstations++;
           }
        }



    //    System.out.println(setuploc);
        return minstations-stations.length;

    }

//    private static int setup(int idx, int[] stations,int w,int n) {
//
//    }



}

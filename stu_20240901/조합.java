package stu_20240901;

import java.util.ArrayList;
import java.util.Arrays;



public class 조합 {
    public static void main(String[] args) {
        int n = 3;
        long k = 5;

        Long[] factorial=new Long[20];
        factorial[0]=1L;
        ArrayList<Integer> numberist = new ArrayList<>();
        for(int i=1;i<factorial.length;i++){
            factorial[i]=factorial[i-1]*(i+1);
        }



        for (int i = 1; i <= n; i++) {
            numberist.add(i);
        }
        int[] result=new int[n];

        int loc=0;
        while (numberist.size()!=1){
            Long fact = factorial[numberist.size()-2];
            for(int i=0;i<numberist.size();i++){

                if(i*fact <= k && (i+1)*fact >= k){
                    result[loc]=numberist.get(i);
                    numberist.remove(i);
                    k-=i*fact;
                    loc++;
                    break;
                }
            }
        }
        result[n-1]=numberist.get(0);

        System.out.println(Arrays.toString(result));





    }


}

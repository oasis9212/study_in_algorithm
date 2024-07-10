package 스스로한다;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 시소짝궁 {

    public static void main(String[] args) {
        int[] weights = {180,180,360,360};
        long count = 0;


        int[] oriweights= new int[1001];
        int[] mulweights= new int[4001];

        for (int w : weights){

            long temp=oriweights[w];
            int m2= w *2;
            int m3= w *3;
            int m4= w *4;

            if(temp>0){  // 몸무개같은것이 체크가 된다.
                count += temp;
                // 곱해서 몸무개가 같은케이스
                count += mulweights[m2] - temp;
                count += mulweights[m3] - temp;
                count += mulweights[m4] - temp;

            }else{
                count += mulweights[m2];
                count += mulweights[m3];
                count += mulweights[m4];
            }

            oriweights[w]++;
            mulweights[m2] ++;
            mulweights[m3] ++;
            mulweights[m4] ++;


        }


    }
}
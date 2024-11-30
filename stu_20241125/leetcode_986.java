package stu_20241125;

import java.util.Arrays;

public class leetcode_986 {
    public static void main(String[] args) {
        int[] tokens={1,2,3,4};
        int power=100;
        Arrays.sort(tokens);
        int Fidx=0;
        int Lidx=tokens.length-1;
        int point=0;

        while(Fidx<=Lidx){
            if(tokens[Fidx]<=power){
                point++;
                power-=tokens[Fidx];
                Fidx++;
            }else{
                if(power+tokens[Lidx]-tokens[Fidx] > power && point!=0){
                    power=power+tokens[Lidx]-tokens[Fidx];
                    Fidx++;
                }
                Lidx--;
            }
        }

    }
}

package stu_20241028;

import java.util.Arrays;

public class leetcode_2545 {
    public static void main(String[] args) {

        int [][]score={{10,6,9,1}, {7,5,11,2}, {4,8,3,15}};
        int k=2;
        Arrays.sort(score,(a,b) -> Integer.compare(b[k] ,a[k]));
    }

}

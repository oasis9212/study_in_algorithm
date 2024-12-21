package stu_20241214;

import java.util.Arrays;

public class h_index {
    public static void main(String[] args) {

        System.out.println(h_index_sol(new int[]{3, 0, 6, 1, 5}));
    }

    private static int h_index_sol(int[] citations) {

        Arrays.sort(citations);
        int len= citations.length;
        int idx=0;
        int result=0;
        while(citations.length>idx){
            if(citations[idx] >= len-idx){
                result=len-idx;
                break;
            }
            idx++;
        }
        /*
        * 정렬된 배열 값
        * 배열에 위치한 인덱스 값 뒤에 남아 있는 길이보다 클 경우 바로 리턴.
        * */
        return result;


    }
}

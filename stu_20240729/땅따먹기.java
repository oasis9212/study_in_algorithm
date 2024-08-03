package stu_20240729;

import java.util.Arrays;

public class 땅따먹기 {
//https://school.programmers.co.kr/learn/courses/30/lessons/12913
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};


        int[] answerLand = land[0];  // 첫번째 땅은 디폴트로 설정.
        for (int i = 1; i < land.length; i++) {
            int[] changeLand = new int[4];
            for (int k = 0; k < land[i].length; k++) {
                changeLand[k] = maxVal(land[i][k], answerLand, k);  // 0번 -> 1번째 배열로 건너 뛰면서 1번째 배열중에서 가장 큰 값을 가질수 있는 값을 선택.
            }
            answerLand = changeLand;  // 0번 -> 1번으로 이동하면서 제일 큰값으로 선택.

        }

        Arrays.sort(answerLand);

        System.out.println(answerLand[3]);
    }

    private static int maxVal(int currentVal, int[] answerLand, int loc) {

        int findVal = 0;

        for (int i = 0; i < answerLand.length; i++) {
            if (loc == i) { // 같은 칸을 제외하고 제일 큰 숫자를 찾는다.
                continue;
            }
            findVal = Math.max(findVal, answerLand[i]);
        }

        return currentVal + findVal;  // 이전 배열의 제일 큰숫자(자기 자신 칸 제외)+ 현재 칸
    }
}

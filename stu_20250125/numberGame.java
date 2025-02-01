package stu_20250125;

import java.util.Arrays;

public class numberGame {

    public static void main(String[] args) {

        System.out.println(sol_numGame(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));

    }

    private static int sol_numGame(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        /*
             두 집단을 정렬한 뒤에 A에 가장 작은 숫자 부터 B에서 가장 작은 숫자 비교를 한다.
              여기서 A에 대한 순서는 전혀 상관이 없다.
         * */
        int total = 0;
        int Aidx = 0;
        for (int bNum : B) {
            if (bNum > A[Aidx]) { // bNum 이 더 클경우 다음으로 작은 A 숫자와 비교하여 진행.
                total++;
                Aidx++;
            }
        }

        return total;
    }
}

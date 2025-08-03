package stu_20250713;


public class 완전범죄 {
    public static void main(String[] args) {

        System.out.println(sol_완전범죄(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4));
    }

    private static int sol_완전범죄(int[][] info, int n, int m) {
        // 전부다 m 의 값을 선택한다고 생각
        // msum - m  => 3 일경우 배열중에서 하나만 빼면 됨
        // msum - m  < 3 일경우는 배열 여러개를 빼야함.

        int msum = 0;

        int nsum = 0;

        int[][] Mary = new int[3][3];
        // M도둑 은 가로  n 도둑은 새로

        for (int[] ary : info) {
            msum += ary[1];
            Mary[ary[1] - 1][ary[0] - 1]++;
        }


        if (msum < m) {
            return 0;

        } else if (msum - m < 3) {
            int a = msum - m;  //  만약 msum - m = 2 경우 3배열에서 무조건빼야하고
            //    1  이면 2~3 배열에서 빼면되고
            // 0 이면 다가능함.
            if (a == 2) {
                int xx = -1;
                for (int i = 0; i < 3; i++) {
                    if (Mary[2][i] > 0) {
                        xx = i + 1;
                        break;
                    }
                }

            } else if (a == 1) {

            } else {

            }


        } else {
            for (int i = 2; i >= 0; i--) {
                for (int j = 0; j <= 2; j++) {
                    while (Mary[i][j] > 0) {
                        Mary[i][j]--;
                        msum -= (i + 1);
                        nsum += j + 1;

                        if (msum < m) {
                            return nsum;
                        }

                    }
                }
            }
        }


        return -1;
    }
}

package stu_20250317;

public class leetcode_1415 {

    public static void main(String[] args) {
        System.out.println(sol_1415(1, 3));

    }

    private static String sol_1415(int n, int k) {

        int totalCases = 3; // 초기 경우의 수

        int len=1;

        for (int i = 1; i < n; i++) {
            totalCases *= 2;
        }

        if (k > totalCases) {
            return "";
        }

        StringBuilder sb= new StringBuilder();

        char prev='a'-1;

        int sblocation=totalCases/3;

        int abcres= totalCases/sblocation;
        abcres-= totalCases%sblocation  == 0 ? 1 : 0;





        return  sb.toString();
    }

}

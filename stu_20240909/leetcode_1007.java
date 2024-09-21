package stu_20240909;

public class leetcode_1007 {

    public static void main(String[] args) {

        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        int answer = minDominoRotations(tops, bottoms);

        System.out.println(answer);
    }

    private static int minDominoRotations(int[] tops, int[] bottoms) {
        for (int i = 1; i <= 6; i++) {
            int result = check(tops, bottoms, i);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
    private  static int check(int[] tops, int[] bottoms, int number) {
        int countTop = 0, countBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != number && bottoms[i] != number) {
                return -1;
            }
            if (tops[i] != number) {
                countTop++;
            } else if (bottoms[i] != number) {
                countBottom++;
            }
        }
        return Math.min(countTop, countBottom);
    }

}

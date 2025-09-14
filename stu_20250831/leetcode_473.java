package stu_20250831;

public class leetcode_473 {
    public static void main(String[] args) {
        System.out.println(sol_473(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,6}));
     //   System.out.println(sol_473(new int[]{3,3,3,3,4}));
    }

    private static boolean sol_473(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int[] matchSquare = new int[4];

        return backtrack_473(matchSquare, 0, sum / 4, matchsticks);


    }

    private static boolean backtrack_473(int[] matchSquare, int idx, int squarelen, int[] matchsticks) {
        if (idx == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < matchSquare.length; i++) {

            if (matchSquare[i] + matchsticks[idx] > squarelen) continue;
            matchSquare[i] += matchsticks[idx];
            if (backtrack_473(matchSquare, idx + 1, squarelen, matchsticks)) {
                return true;
            }
            matchSquare[i] -= matchsticks[idx];
            if (matchSquare[i] == 0) break;
        }
        return false;

    }


}

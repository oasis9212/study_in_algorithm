package stu_20250105;

public class leetcode_2391 {
    public static void main(String[] args) {
        String[] garbage = new String[]{"G", "P", "GP", "GG"};
        int[] travel = new int[]{2, 4, 3};
        System.out.println(sol_2391(garbage, travel));
        System.out.println(sol_2391(new String[]{"MMM","PGM","GP"}, new int[]{3,10}));

    }

    private static int sol_2391(String[] garbage, int[] travel) {
        int result = 0;
        char[] truck = new char[]{'G', 'P', 'M'};
        // 트럭이 어디까지 갈까?
        int[] truckIdx = new int[]{-1,-1,-1};
        for (int i = garbage.length - 1; i >= 0; i--) {
            if (truckIdx[0] == -1 && garbage[i].indexOf('G') > -1) {
                truckIdx[0] = i;
            }
            if (truckIdx[1] == -1 && garbage[i].indexOf('P') > -1) {
                truckIdx[1] = i;
            }
            if (truckIdx[2] == -1 && garbage[i].indexOf('M') > -1) {
                truckIdx[2] = i;
            }
            if (truckIdx[0] != -1 && truckIdx[1] != -1 && truckIdx[2] != -1) {
                break;
            }
        }

        int getcount = 0;
        for (int i = 0; i < truck.length; i++) {
            if (truckIdx[i] == -1) continue;
            for (int j = 0; j <= truckIdx[i]; j++) {
                getcount += getCount(garbage[j], truck[i]);
                getcount += j == 0 ? 0 : travel[j - 1];
            }

        }


        return getcount;

    }

    private static int getCount(String garbage, char c) {
        int total = 0;
        for (int i = 0; i < garbage.length(); i++) {
            if (garbage.charAt(i) == c) {
                total++;
            }
        }
        return total;
    }
}

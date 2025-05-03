package stu_20250422;

public class 유연근무제 {
    public static void main(String[] args) {

        System.out.println(sol_유연(new int[]{730, 855, 700, 720}
                , new int[][]{{710, 700, 650, 735, 700, 931, 912},
                        {908, 901, 805, 815, 800, 831, 835},
                        {705, 701, 702, 705, 710, 710, 711},
                        {707, 731, 859, 913, 934, 931, 905}},
                1));

    }

    private static int sol_유연(int[] schedules, int[][] timelogs, int startday) {
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] = (schedules[i] / 100) * 60 + schedules[i] % 100 + 10;
        }
        int res = 0;
        loop:
        for (int i = 0; i < timelogs.length; i++) {
            int day = startday;
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day < 6) {
                    int time = (timelogs[i][j] / 100) * 60 + timelogs[i][j] % 100;

                    if (time > schedules[i]) {
                        continue loop;
                    }

                }
                if (day == 7) {
                    day = 1;
                } else {
                    day++;

                }
            }
            res++;
        }

        return res;
    }
}

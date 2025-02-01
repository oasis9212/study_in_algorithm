package stu_20250125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetCode_1253 {

    public static void main(String[] args) {
        System.out.println(sol_1253(2, 1, new int[]{1, 1, 1}));

    }

    private static List<List<Integer>> sol_1253(int upper, int lower, int[] colsum) {
        List<Integer> UAry = new ArrayList<>();
        List<Integer> LAry = new ArrayList<>();
        for (int j : colsum) {
            switch (j) {
                case 2:
                    upper--;
                    lower--;
                    UAry.add(1);
                    LAry.add(1);
                    break;
                case 1:
                    if (upper >= lower) {
                        upper--;
                        UAry.add(1);
                        LAry.add(0);
                    } else {
                        lower--;
                        UAry.add(0);
                        LAry.add(1);
                    }
                    break;
                default:
                    UAry.add(0);
                    LAry.add(0);
                    break;
            }
            if (upper < 0 || lower < 0) {
                return new ArrayList<>();
            }

        }

        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(UAry);
        list.add(LAry);
        return list;

    }
}
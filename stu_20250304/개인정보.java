package stu_20250304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 개인정보 {

    public static void main(String[] args) {
        //  System.out.println(Arrays.toString(sol_개인정보("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
        System.out.println(Arrays.toString(sol_개인정보("2009.12.28", new String[]{"A 13"}, new String[]{"2008.11.03 A"})));
    }

    private static int[] sol_개인정보(String today, String[] terms, String[] privacies) {
        int[] endday = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        if (endday[2] == 28) {
            endday[2] = 1;
            endday[1]++;
            if (endday[1] == 13) {
                endday[1] = 1;
                endday[0]++;
            }
        } else {
            endday[2]++;
        }
        HashMap<String, Integer> termHash = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termHash.put(s[0], Integer.parseInt(s[1]));
        }

        List<Integer> list = new ArrayList<Integer>();


        for (int i = 0; i < privacies.length; i++) {
            String[] data = privacies[i].split(" ");
            int[] date = Arrays.stream(data[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            int getterm = termHash.get(data[1]);
            date[1] += getterm;
            int plusyear = date[1] / 12;
            date[1] %= 12;
            date[0] += plusyear;
            date[0] = date[1] == 0 ? date[0] - 1 : date[0];
            date[1] = date[1] == 0 ? 12 : date[1];

            if (date[0] != endday[0]) {
                if (date[0] < endday[0]) {
                    list.add(i + 1);
                }
                continue;
            }
            if (date[1] != endday[1]) {
                if (date[1] < endday[1]) {
                    list.add(i + 1);
                }
                continue;
            }
            if (date[2] != endday[2]) {
                if (date[2] < endday[2]) {
                    list.add(i + 1);
                }
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

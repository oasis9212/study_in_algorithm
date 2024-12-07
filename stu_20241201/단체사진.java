package stu_20241201;

import java.util.*;

public class 단체사진 {


    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        int[] fact = new int[9];
        fact[1] = 1;
        for (int i = 2; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
        }

        List<cond> list = new ArrayList<>();  // 이건 data 의 조건을 리스트화로 시켜 리스트에 대한
        Set<Character> oriset = new HashSet<>();  // data 조건에서 알파벳이 중복될수 있으니 set으로 설정했다.
        for (int i = 0; i < data.length; i++) {
            cond c = new cond(data[i].charAt(0), data[i].charAt(2), data[i].charAt(3), data[i].charAt(4) - '0');
            list.add(c);
            oriset.add(data[i].charAt(0));
            oriset.add(data[i].charAt(2));
        }


        int total = gettotal_2(list, oriset, fact[8 - oriset.size()]);
        System.out.println(total);

    }



    private static int gettotal_2(List<cond> list, Set<Character> oriset, int factnum) {

        List<HashMap<Character, Integer>> result = new ArrayList<>();
        List<Character> newset = new ArrayList<>(oriset);
        int total = 0;
        Permutations(result, newset, new boolean[8], new char[newset.size()], new int[newset.size()], 0);


        loop:
        for (HashMap<Character, Integer> hs : result) {
            for (cond cond : list) {
                if (!cond.tongGuo(hs)) {
                    continue loop;
                }
            }
            total += 1;
        }
        return total*factnum;
    }

    private static void Permutations(List<HashMap<Character, Integer>> result, List<Character> newset, boolean[] used, char[] charary, int[] charloc, int idx) {
        if (idx == newset.size()) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < charloc.length; i++) {
                map.put(charary[i], charloc[i]);
            }
            result.add(map);
            return;
        }
        Character choose = newset.get(idx);
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                charary[idx] = choose;
                charloc[idx] = i;
                Permutations(result, newset, used, charary, charloc, idx + 1);
                used[i] = false;
            }
        }
    }
}


class cond {

    char from;
    char to;
    int condition;  // 0 ==   |   1 >  | 2 <
    int num;

    public cond(char from, char to, char condition, int num) {
        this.from = from;
        this.to = to;
        switch (condition) {
            case '=':
                this.condition = 0;
                break;
            case '>':
                this.condition = 1;
                break;
            case '<':
                this.condition = 2;
                break;
        }
        this.num = num;
    }

    public boolean tongGuo(Map<Character, Integer> location) {

        int a = location.get(this.from);
        int b = location.get(this.to);
//        int dist = Math.abs(a - b) - 1;
//
//        if (this.condition == 0 && dist != this.num) {
//            return false;
//        } else if (this.condition == 1 && dist <= this.num) {
//            return false;
//        } else if (this.condition == 2 && dist >= this.num) {
//            return false;
//        }
//        return true;

        // 아니 뭐가 다르지?
        return switch (this.condition) {
            case 0 -> Math.abs(a - b) - 1 == this.num;
            case 1 -> Math.abs(a - b) - 1 >= this.num;
            case 2 -> Math.abs(a - b) -1 <= this.num;
            default -> true;
        };
    }
// 70

}
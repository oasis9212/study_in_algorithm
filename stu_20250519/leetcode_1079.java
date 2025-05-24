package stu_20250519;

import java.util.*;

public class leetcode_1079 {

    public static void main(String[] args) {

        System.out.println(sol_1079("AAB"));
    }

    private static int sol_1079(String tiles) {

        Set<String> se= new HashSet<>();
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            hs.put(tiles.charAt(i)+"", hs.getOrDefault(tiles.charAt(i)+"", 0) + 1);
        }
        List<alpha_1079> list= new ArrayList<>();
        hs.forEach((k, v) -> list.add(new alpha_1079(k, v)));

        for (int i = 0; i < list.size(); i++) {
            addProcess(se,list,i, list.get(i).c);
        }
        return  se.size();
    }

    private static void addProcess(Set<String> se, List<alpha_1079> list, int idx,String s) {

        if(list.get(idx).count!=0 && se.add(s)){
            list.get(idx).count--;
            for (int i = 0; i < list.size(); i++) {
                addProcess(se,list,i,s+list.get(i).c);
            }
            list.get(idx).count++;
        }

    }
}

class  alpha_1079 {

    String c;
    int count;

    public alpha_1079(String c, int count) {
        this.c = c;
        this.count = count;
    }

    public void minusCount(){
        this.count--;
    }

}
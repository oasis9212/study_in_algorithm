package stu_20250105;

import java.util.*;

public class network {
    public static void main(String[] args) {
        System.out.println(sol_network(3,new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static int sol_network(int n, int[][] computers) {
        List<List<Integer>> linking= new ArrayList<>();
        ArrayList<Integer> set= new ArrayList<>();  // boolean 방식 말고 다른 방식으로 풀어봄.
        for (int i = 0; i < computers.length; i++) {
            linking.add(new ArrayList<>());
            set.add(i);
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if(j==i) continue;
                if(computers[i][j]==1){
                    linking.get(i).add(j);
                }
            }
        }
        int total=0;

        Queue<Integer> qu = new LinkedList<>();
        while (!set.isEmpty()){
            qu.add(set.get(0));
            set.remove(set.get(0));

            while (!qu.isEmpty()){
                int val= qu.poll();
                List<Integer> linked=linking.get(val);
                for (int i = 0; i < linked.size(); i++) {
                    if(set.contains(linked.get(i))){
                        qu.add(linked.get(i));
                        set.remove(linked.get(i));
                    }
                }

            }
            total++;
        }



        return total;
    }
}

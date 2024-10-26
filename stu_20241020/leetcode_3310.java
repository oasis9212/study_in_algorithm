package stu_20241020;

import java.util.*;


public class leetcode_3310 {
    boolean[] target;

    public static void main(String[] args) {
        int n = 5;
        int k = 0;
        int[][] invocations = {{1, 2}, {0, 2}, {0, 1}, {3, 4}};

        List<Integer> sol = sol(n, invocations, k);

        System.out.println(sol.toString());

    }

    private static List<Integer> sol(int n, int[][] invocations, int k) {
        List<node_3310> list = new ArrayList<>();  // 연결 리스트
        List<Integer> Alllist = new ArrayList<>();  //리스트 전부
        List<Integer> normallist = new ArrayList<>();// 감염된 리스트는 뺀다.
        boolean[] visit = new boolean[n];
        boolean[] infection = new boolean[n];// 감염된것은 true
        for (int i = 0; i < n; i++) {
            list.add(new node_3310(i));
            Alllist.add(i);
            normallist.add(i);
        }
        // dfs 구조 만듬.
        // i[0] -> i[1] 이부분만 연결
        for (int[] i : invocations) {
            list.get(i[0]).linked.put(i[1], true);
            list.get(i[1]).linked.put(i[0], false);
        }

        boolean TF=dfs(list, k, infection, visit, normallist);  // 감염된 리스트 만들기.
        //boolean TF=dfs2(list,normallist,visit,infection);

        if (TF) {
            return normallist;
        } else {
            return Alllist;
        }


    }


    private static boolean dfs(List<node_3310> list, int k, boolean[] infection, boolean[] visit, List<Integer> normallist) {
        Stack<Integer> st = new Stack<>();
        st.add(k);
        while (!st.isEmpty()) {
            int n = st.pop();
            node_3310 d = list.get(n);
            infection[n] = true;
            visit[n] = true;
            normallist.remove(Integer.valueOf(n));
            for(Integer key: d.linked.keySet()){
                if(d.linked.get(key) && !visit[key]){
                    st.add(key);
                }
            }
        }
        st.add(k);
        while (!st.isEmpty()){
            int n = st.pop();
            node_3310 d = list.get(n);
            for(Integer key: d.linked.keySet()){
                if(!d.linked.get(key) && !infection[key]){
                    return false;
                }else{
                    st.add(key);
                }
            }
        }

        return true;
    }

}


class node_3310 {

    int num;
    Map<Integer, Boolean> linked;  // 연결 대상 / true 는  호출  false 호출 받는
    boolean visited;
    boolean infection;

    public node_3310(int num) {
        this.num = num;
        this.linked = new HashMap<>();
        this.visited = false;
        this.infection = false;
    }
}

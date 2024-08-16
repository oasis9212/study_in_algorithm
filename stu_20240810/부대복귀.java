package stu_20240810;

import java.util.*;

public class 부대복귀 {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;
        List<node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new node(i));  // 0 은 계산 하기 귀찮아서 생성.
        }
        for (int[] road : roads) {
            nodes.get(road[0]).addLinked(nodes.get(road[1]));
            nodes.get(road[1]).addLinked(nodes.get(road[0]));
        }

        int[] answer = new int[sources.length];
        // destination  -> sources 뜻 ==  sources-> destination
        goShort(nodes, destination);  // destination 각 구역의 길이를 다 구해준다는 방식으로 풀이.
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nodes.get(sources[i]).passed ? -1 : nodes.get(sources[i]).range;
        }
        System.out.println(Arrays.toString(answer));

    }

    private static void goShort(List<node> nodes, int destination) {

        node start = nodes.get(destination);
        start.passed = false;  // destination 의값 부터 시작.
        Queue<node> qu = new LinkedList<>();
        qu.add(start);
        while (!qu.isEmpty()) {
            node n = qu.poll();
            for (node d : n.linked) {
                if (d.passed) {
                    d.passed = false;  //  false 의 의미 여기서 부터 난 값은 최소값이다.
                    d.range = n.range + 1;
                    qu.add(d);
                }
            }
        }
    }
}


class node {

    List<node> linked;
    boolean passed;
    int range;

    public node(int num) {
        this.linked = new ArrayList<>();
        passed = true;
        range = 0;
    }

    void addLinked(node n) {
        linked.add(n);
    }
}
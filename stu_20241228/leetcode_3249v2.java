package stu_20241228;

import java.util.*;

public class leetcode_3249v2 {

    public static void main(String[] args) {
       //System.out.println(sol_3249(new int[][]{{6,0},{1,0},{5,1},{2,5},{3,1},{4,3}}));
       //System.out.println(sol_3249(new int[][]{{0,1},{1,2},{1,3},{1,4},{0,5},{5,6},{6,7},{7,8},{0,9},{9,10},{9,12},{10,11}}));
        System.out.println(sol_3249(new int[][]{{0,1},{1,2},{2,3},{3,4},{0,5},{1,6},{2,7},{3,8}}));


    }

    private static int sol_3249(int[][] edges) {
        List<Node_v2> list = new ArrayList<>();
        Set<Integer> lastnode = new HashSet<>();
        for (int i = 0; i <= edges.length; i++) {
            list.add(new Node_v2());
        }
        // 노드 간의 부모 자식을 현재 모르는 상태이기 때문에 서로간에 연결만 한다.
        for (int[] edge : edges) {
            list.get(edge[0]).linked.add(edge[1]);
            list.get(edge[1]).linked.add(edge[0]);
        }

        // 맨끝 노드 파악.  0번은 제외
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).linked.size()==1){
                lastnode.add(i);
                list.get(i).passed=true;
            }
        }
        Queue<Integer> qu = new LinkedList<>(lastnode);

        while (!qu.isEmpty()) {
            int nodeChild = qu.poll();
            if (nodeChild==0) continue;
            Node_v2 currentNode = list.get(nodeChild);
            int nodeParent=0;  // 부모값
            for (int i: currentNode.linked) {  // Set이 있는 값을 가져오기 위한 것.
                nodeParent= i;
            }
            Node_v2 parentNode =list.get(nodeParent);
            parentNode.linked.remove(nodeChild);        //
            parentNode.Child.add(nodeChild);
            parentNode.count+= currentNode.count;
            if(!parentNode.passed || parentNode.linked.size()>=2 ){
                parentNode.passed=true;
                qu.add(nodeParent);
            }

        }

        int total=0;
        for (Node_v2 node : list) {
            if(node.Child.isEmpty() || node.Child.size()==1){
                total++;
                continue;
            }

            int firstChildCount= list.get(node.Child.get(0)).count;
            boolean isGoodNode = true;

            for (int childIndex: node.Child){
                if(list.get(childIndex).count != firstChildCount){
                    isGoodNode =false;
                    break;
                }
            }
            if(isGoodNode) total++;

        }


        return total;
    }
}
class Node_v2 {

    Set<Integer> linked;
    List<Integer> Child=new ArrayList<>();
    int count;
    boolean passed;

    public Node_v2() {
        this.linked = new HashSet<>();
        this.count = 1;
        this.passed = false;
    }
}
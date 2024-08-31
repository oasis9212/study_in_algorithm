package stu_20240822;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class path_maximun {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}};
        double[] succProb = {0.5};
        int start = 0;
        int end = 2;
        List<List<Node>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new Node(b, prob));
            graph.get(b).add(new Node(a, prob));
        }

        PriorityQueue<Node> pq= new PriorityQueue<>();
        pq.offer(new Node(start,1.0));

        double[] maxval=new double[n];
        maxval[start]= 1.0;

        double  result=0.0;

        while (!pq.isEmpty()){
            Node cur= pq.poll();
            int curIndex= cur.index;
            double curVal= cur.val;

            if(curIndex == end){
                result=curVal;
                break;
            }


            if(curVal < maxval[curIndex]){
                continue;
            }

            for(Node d: graph.get(curIndex)){
               double newProb= curVal  * d.val;
               if(newProb > maxval[d.index]){
                   maxval[d.index] = newProb;
                   pq.offer(new Node(d.index,newProb));
               }
            }
        }
        System.out.println(result);

    }
}

class Node  implements  Comparable<Node>{
    int index;
    double val;

    public Node(int index,double val) {
        this.index = index;
        this.val = val;
    }


    @Override
    public int compareTo( Node o) {
        return Double.compare(o.val, this.val);
    }
}

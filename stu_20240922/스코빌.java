package stu_20240922;
import java.util.*;
public class 스코빌 {
    public static void main(String[] args) {
        int[] scoville={1, 2, 3, 9, 10, 12};
        int K=7;
        int answer = 0;

        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        for(int i: scoville) {
            pq.add(i);
        }
        if(pq.peek()>=K) {
            answer=0;
        }else {
            while(pq.size()>1) {
                int one = pq.poll();
                int two = pq.poll();

                int mixed = one+(two*2);
                pq.add(mixed);
                answer++;
                if(pq.peek()>=K) {
                    break;
                }
            }
        }

        if(pq.peek()<K){
            answer=-1;
        }
    }
}

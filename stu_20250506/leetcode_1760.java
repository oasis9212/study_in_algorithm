package stu_20250506;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_1760 {
    public static void main(String[] args) {

        System.out.println(sol_1760(new int[]{9},200));
    }

    private static int sol_1760(int[] nums , int maxOperations ) {

        PriorityQueue<solbag> ss= new PriorityQueue<>((a, b) -> b.getMaxSize() - a.getMaxSize());
        for (int num: nums){
            ss.add(new solbag(num,1));
        }

        int number=0;
        for (int i = 0; i < maxOperations; i++) {
           solbag b= ss.poll();
           if(b.count == b.original){
               break;
           }
           b.count++;
           ss.add(b);

        }

        return  ss.isEmpty() ? 1: ss.peek().getMaxSize();
    }
}

class solbag{
    int original;  // 원래 공 개수
    int count;     // 현재 이 공을 나눈 가방 수

    solbag(int original, int count) {
        this.original = original;
        this.count = count;
    }

    int getMaxSize() {
        return (original + count - 1) / count;  // ceiling division
    }
}

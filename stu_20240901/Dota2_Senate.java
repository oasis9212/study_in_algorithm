package stu_20240901;

import java.util.LinkedList;
import java.util.Queue;


public class Dota2_Senate {
    public static void main(String[] args) {
        String senate="RDD";
        Queue<Integer> quD= new LinkedList<>();
        Queue<Integer> quR= new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                quR.offer(i);
            }else {
                quD.offer(i);
            }
        }
        int nextRound=senate.length();  // 스트링 한번만 하는 것이 아닌 여러번 시행이 가능하다.
        while (!quR.isEmpty() && !quD.isEmpty()){
            if(quR.peek() > quD.peek()){
                quR.poll();
                quD.offer(quD.poll()+nextRound);
            }else {
                quD.poll();
                quR.offer(quR.poll()+nextRound);
            }
        }

        String d= quR.isEmpty() ? "Dire"  : "Radiant";


        System.out.println(d);










    }
}

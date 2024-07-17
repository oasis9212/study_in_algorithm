package 스스로한다;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 호텔_대실 {
    public static void main(String[] args) {
        String[][] book_time= {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
            int[][] book_timeint=new int[book_time.length][2];
            for(int i=0;i<book_time.length;i++){
                String st= book_time[i][0];
                int sthour= Integer.parseInt(st.substring(0,2))*60;
                int stmin=Integer.parseInt(st.substring(3));
                book_timeint[i][0]=sthour+stmin;
                String se= book_time[i][1];
                int sehour= Integer.parseInt(se.substring(0,2))*60;
                int semin=Integer.parseInt(se.substring(3))+10;
                book_timeint[i][1]=sehour+semin;
            }
        Arrays.sort(book_timeint, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int i= 0; i< book_timeint.length;i++){
            if(!pq.isEmpty()){
                if(pq.peek() <= book_timeint[i][0]){
                    pq.poll();
                }
            }
            pq.add(book_timeint[i][1]);
        }

        System.out.println(pq.size());



    }
}

package stu_20240729;

import java.util.*;

public class 차_집단 {
    public static void main(String[] args) {
        int target=12;
        int[] position={10,8,0,5,3};
        int[] speed={2,4,1,1,3};

        pair[] pairs= new pair[position.length];
        for(int i=0;i<position.length;i++){
            pairs[i]=new pair(position[i],speed[i]);
        }
        Arrays.sort(pairs, (o1, o2) -> o2.position-o1.position);

        int answer=0;
        double curtime=0;
        for(int i=0;i<pairs.length;i++){
            double landtime= (double) (target- pairs[i].position) / pairs[i].speed;
            if(curtime < landtime){
                answer++;
                curtime= landtime;
            }
        }

        System.out.println(answer);




    }
}


class pair{

    int position;
    int speed;

    public pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
package stu_20250831;

import java.util.*;

public class 충돌위험 {
    public static void main(String[] args) {

        //System.out.println(sol_충돌위험(new int[][]{{3, 2},{6, 4},{4, 7},{1, 4}},new int[][]{{4, 2},{1, 3},{2, 4}}));
        System.out.println(sol_충돌위험(new int[][]{{3, 2},{6, 4},{4, 7},{1, 4}},new int[][]{{4, 2},{1, 3},{4, 2},{4, 3}}));


    }

    private static int sol_충돌위험(int[][] points, int[][] routes) {
        
        // y의 범위는 1~100
        // X의 범위는 1*1000~100*1000     1000 ~100,000'
        // 0초 부터 계산해야할것이 있어서 먼저 계산진행
        Set<Integer> currobotloc=  new HashSet<>();  // 로봇의 위치 중복되면
        Set<Integer> crashAlready=  new HashSet<>();  // 이미 충돌난것은 계산을 하지않는다.
        int count =0 ;
        List<robot> robotList=new ArrayList<>();
        for (int i=0;i<routes.length;i++){
            int startroute= routes[i][0];
            int[] startpoint= points[startroute-1];
            robotList.add(new robot(startpoint[0],startpoint[1],routes[i]));
            if (!currobotloc.add(robotList.get(i).y + robotList.get(i).x * 1000) && crashAlready.add(robotList.get(i).y + robotList.get(i).x * 1000)) {
                count++;
            }
        }

        currobotloc.clear();
        crashAlready.clear();



        while (!robotList.isEmpty()){
            Iterator<robot> it = robotList.iterator();
            while (it.hasNext()) {
                robot r = it.next();
                int[] gopoint = points[r.route[r.goingRoute] - 1];

                // 이동 로직...
                if (Math.abs(r.y - gopoint[0]) > 0) {
                    r.y += r.y - gopoint[0] > 0 ? -1 : 1;
                } else {
                    r.x += r.x - gopoint[1] > 0 ? -1 : 1;
                }

                if (!currobotloc.add(r.y + r.x * 1000) && crashAlready.add(r.y + r.x * 1000)) {
                    count++;
                }

                if (r.y == gopoint[0] && r.x == gopoint[1]) {
                    r.goingRoute++;
                    if (r.goingRoute >= r.route.length) {
                        it.remove(); // 안전하게 제거 가능
                    }
                }
            }

            currobotloc.clear();
            crashAlready.clear();
            
            
        }
        

        return count;
    }
}


class robot {
    int y;
    int x;
    int[] route;

    int goingRoute=1;


    public robot(int y, int x ,int[] route) {
        this.route= route;
        this.y = y;
        this.x = x;

    }

}

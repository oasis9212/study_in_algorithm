package stu_20240810;


public class 최소티켓 {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        // days 마다 최소값을 구해보자??
        // 1일권은 무조건 전항의 + 하면 구해짐.
        // 7일권은 전일자 - 현일자.
        // 각 데이의 최소값을 구해보자.
        int[] daycost = new int[days[days.length - 1] + 1];  // 0일 추가 하자.
        int idx = 0;
        int goTicket = days[idx];
        for (int i = 1; i < daycost.length; i++) {
            if (i == goTicket) {
                int oneday = daycost[i - 1] + costs[0];
                int sevencheck= Math.max(i - 7, 0);
                int sevenday = daycost[sevencheck] + costs[1];

                int monthcheck= Math.max(i-30,0);
                int monthday = daycost[monthcheck] + costs[2];
                daycost[i] = Math.min(oneday, Math.min(sevenday, monthday));

                    if(i!=daycost.length-1){
                        goTicket = days[++idx];
                    }


            } else {
                daycost[i] = daycost[i - 1];
            }


        }
        System.out.println(daycost[daycost.length-1]);


    }


}

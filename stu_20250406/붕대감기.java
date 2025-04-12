package stu_20250406;

public class 붕대감기 {
    public static void main(String[] args) {

   //     System.out.println(sol_붕대( new int[]{5,1,5}, 30, new int[][]{{2,10},{9,15},{10,5},{11,5}} ));
        System.out.println(sol_붕대( new int[]{3,2,7}, 20, new int[][]{{1,15},{5,16},{8,6}} ));

    }

    private static int sol_붕대(int[] bandage, int health, int[][] attacks) {
        // 어쩌피 풀피에서 밴드를 감아도 별상관없으니 공격받은 시점에서 로직을 시작.
        int starttime= attacks[0][0];
        int starthealth= health-attacks[0][1];

        for (int i = 1; i < attacks.length; i++) {
            int healtime=attacks[i][0] -starttime-1; // -1 한건 몬스터 공격받을때는 붕대 치료가 안되서.
            int bandSuccess=healtime/bandage[0];
            int bandFail=healtime%bandage[0];

            int SuccessHealtime=bandSuccess*bandage[2]+bandSuccess*bandage[0]*bandage[1];
            int FailHealtime=bandFail*bandage[1];

            starthealth=Math.min(starthealth+SuccessHealtime+FailHealtime,health);  // 힐량
            starthealth-=attacks[i][1];// 그담에 공격받기
            if(starthealth<=0){
                return -1;
            }
            starttime=attacks[i][0];
        }

        return starthealth;


    }
}

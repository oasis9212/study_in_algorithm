package stu_20240929;

public class 개구리_점프 {
    public static void main(String[] args) {
        // 1 번 건너뛰기는 어쩌피 스톤 맨마지막 값이다.


        int[] stones = {0, 2, 5, 6, 7};
        int answer = stones[stones.length - 1];

        // 몇칸씩 건너 뛰기를 한번 봐야한다.

        int val = GoTF(stones);
        answer = Math.min(answer, val);

        System.out.println(answer);


        //
        int answer2=stones[1]-stones[0];
        for (int i = 2; i < stones.length; i++) {
            answer2=Math.max(answer,stones[i]-stones[i-2]);
        }

    }

    private static int GoTF(int[] stones) {
        boolean[] GoNot = new boolean[stones.length];
        int val = 0;
        int idx = 0;

        int berforeloc = 0;
        int afterloc = 0;

        while (idx < stones.length - 1) {
            if (idx + 2 < stones.length) {
                idx += 2;
            } else {
                idx = stones.length - 1;
            }
            GoNot[idx] = true;
            afterloc = stones[idx];
            val = Math.max(val, Math.abs(berforeloc - afterloc));
            berforeloc = afterloc;
        }
        for (int i = stones.length - 1; i >= 0; i--) {
            if (GoNot[i]) continue;
            afterloc = stones[i];
            val = Math.max(val, Math.abs(berforeloc - afterloc));
            berforeloc = afterloc;
        }
        return val;
    }

}

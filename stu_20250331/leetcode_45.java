package stu_20250331;

public class leetcode_45 {

    public static void main(String[] args) {
        System.out.println(sol_45(new int[]{2,3,1,1,4}));
//        System.out.println(sol_45(new int[]{0}));
 //       System.out.println(sol_45(new int[]{1, 1, 1, 1}));

    }

    private static int sol_45(int[] nums) {

        int[] dist = new int[nums.length];  // 여기 최대로갈수 있는 거리
        // 2,4,3,4,4
        // 4,3
        //
        for (int i = 0; i < dist.length; i++) {

            dist[i] = Math.min(nums[i] + i, nums.length - 1); // 만일 갈수있는 거리가 이미  nums 의 배열을 넘었을 경우 최대거리로 그냥 잡는다.
        }
        int count = 0; // 건너뛰는 갯수 (최소)
        int cur = 0;    // 현재 나의 위치

        while (cur < nums.length - 1) { // 내가 num 까지 갔을때 멈춤.
            count++; // 한번은 건너 뛰게 한다.
            if (dist[cur] == nums.length - 1) break;
            int godist = dist[cur]; // 현재 최대로 갈수 있는 범위를 뜻함.
            int c = cur;
            // 1 - 2
            for (int i = c + 1; i <= dist[c]; i++) {
                if (godist < dist[i]) {
                    godist = dist[i];
                    cur = i;
                }

            }

        }

        return count;
    }

}
